package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYERS_FILE_PATH = "/Users/sezgin/Documents/SoftUni-Self-Learning/Java-DB/Spring-Data/Exam-Prep/skeleton/skeleton/src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final StatService statService;
    private final TownService townService;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             ModelMapper modelMapper,
                             ValidationUtil validationUtil,
                             XmlParser xmlParser,
                             StatService statService,
                             TownService townService,
                             TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.statService = statService;
        this.townService = townService;
        this.teamService = teamService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDTO.class)
                .getPlayers()
                .stream()
                .filter(playerSeedDTO -> {
                    boolean isValid = validationUtil.isValid(playerSeedDTO);

                    if (!isValid || playerRepository.findByEmail(playerSeedDTO.getEmail()) != null) {
                        sb.append("Invalid Player")
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String
                                        .format("Successfully imported Player %s %s - %s"
                                                , playerSeedDTO.getFirstName()
                                                , playerSeedDTO.getLastName()
                                                , playerSeedDTO.getPosition()))
                                .append(System.lineSeparator());
                    }
                    return isValid;
                })
                .map(playerSeedDTO -> {
                    Player player = modelMapper.map(playerSeedDTO, Player.class);

                    String birthDateBeforeFormat = playerSeedDTO.getBirthDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate birthDate = LocalDate.parse(birthDateBeforeFormat, formatter);

                    player.setBirthDate(birthDate);
                    player.setTown(townService.findTownByName(playerSeedDTO.getTownName().getName()));
                    player.setTeam(teamService.findTeamByName(playerSeedDTO.getTeamNameDTO().getName()));
                    player.setStat(statService.findStatById(playerSeedDTO.getStatIdDTO().getId()));

                    return player;

                })
                .forEach(playerRepository::save);


        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        List<Player> players =
                playerRepository.findAllOrderedBySkillsInDescAndOrderedByLastName();
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            sb.append(String.format("Player - %s %s", player.getFirstName(), player.getLastName()))
                    .append(System.lineSeparator())
                    .append(String.format("         Position - %s", player.getPosition()))
                    .append(System.lineSeparator())
                    .append(String.format("         Team- %s", player.getTeam().getName()))
                    .append(System.lineSeparator())
                    .append(String.format("         Stadium - %s", player.getTeam().getStadiumName()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
