package com.example.automappingex.service.impl;

import com.example.automappingex.model.dto.AllGameDto;
import com.example.automappingex.model.dto.DetailGameDto;
import com.example.automappingex.model.dto.GameAddDto;
import com.example.automappingex.model.entity.Game;
import com.example.automappingex.repository.GameRepository;
import com.example.automappingex.service.GameService;
import com.example.automappingex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addGame(GameAddDto gameDto) {
        Set<ConstraintViolation<GameAddDto>> violations
                = validationUtil.violations(gameDto);
        if (violations.isEmpty()) {
            Game game = modelMapper.map(gameDto, Game.class);
            this.gameRepository.save(game);
            return "Added " + gameDto.getTitle();
        } else {
            StringBuilder sb = new StringBuilder();
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(m -> sb.append(String.format("%s%n", m)));
            return sb.toString().trim();
        }
    }

    @Override
    public String editGame(Long id, List<String> values) {
        Game gameForEdit = this.gameRepository.findById(id).orElse(null);

        if (gameForEdit == null) {
            return "Not found game with id: " + gameForEdit.getId();
        } else {
            for (String value : values) {
                String[] tokens = value.split("=");
                switch (tokens[0].toLowerCase()) {
                    case "title":
                        gameForEdit.setTitle(tokens[1]);
                        break;
                    case "price":
                        gameForEdit.setPrice(new BigDecimal(tokens[1]));
                        break;
                    case "size":
                        gameForEdit.setSize(Double.parseDouble(tokens[1]));
                        break;
                    case "trailer":
                        gameForEdit.setTrailer(tokens[1]);
                        break;

                    case "thubnailURL":
                    case "imagethumbnail":
                        gameForEdit.setImageThumbnail(tokens[1]);
                        break;

                    case "description":
                        gameForEdit.setDescription(tokens[1]);
                        break;

                    case "releasedate":
                        gameForEdit.setReleaseDate(LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        break;
                }
                this.gameRepository.save(gameForEdit);
            }
        }
        return "Edited " + gameForEdit.getTitle();
    }

    @Override
    public String deleteGame(Long id) {
        Game game = this.gameRepository.findById(id).orElse(null);
        if (game == null) {
            return "Game with id: " + id + " doesn't exist";
        }
        this.gameRepository.deleteById(id);
        return "Deleted " + game.getTitle();
    }

    @Override
    public List<AllGameDto> findTitleAndPriceOfAllGames() {

        List<AllGameDto> dtos = new ArrayList<>();
        this.gameRepository.findAll()
                .forEach(g -> {
                    dtos.add(modelMapper.map(g, AllGameDto.class));
                });

        return dtos;
    }

    @Override
    public DetailGameDto findGameDetailsByTitle(String title) {
        return this.modelMapper.map(this.gameRepository.findByTitle(title), DetailGameDto.class);
    }

    @Override
    public Game findGameByName(String gameName) {
        return this.gameRepository.findByTitle(gameName);
    }
}
