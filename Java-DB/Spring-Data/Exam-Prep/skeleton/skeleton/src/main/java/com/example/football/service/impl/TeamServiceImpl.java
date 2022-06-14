package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDTO;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAMS_FILE_PATH = "/Users/sezgin/Documents/SoftUni-Self-Learning/Java-DB/Spring-Data/Exam-Prep/skeleton/skeleton/src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, TownService townService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(this.readTeamsFileContent(), TeamSeedDTO[].class))
                .filter(teamSeedDTO -> {
                    boolean isValid = this.validationUtil.isValid(teamSeedDTO);

                    if (!isValid || teamRepository.findByName(teamSeedDTO.getName()) != null) {
                        sb.append("Invalid Town")
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Successfully imported Team %s - %d", teamSeedDTO.getName()
                                , teamSeedDTO.getFanBase()))
                                .append(System.lineSeparator());
                    }

                    return isValid;
                })
                .map(teamSeedDTO -> {
                    Team team = modelMapper.map(teamSeedDTO, Team.class);
                    team.setTown(townService.findTownByName(teamSeedDTO.getTownName()));
                    return team;
                })
                .forEach(teamRepository::save);

        return sb.toString();
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findByName(name);
    }
}
