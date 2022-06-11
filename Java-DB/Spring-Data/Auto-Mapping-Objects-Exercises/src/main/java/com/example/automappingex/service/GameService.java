package com.example.automappingex.service;

import com.example.automappingex.model.dto.AllGameDto;
import com.example.automappingex.model.dto.DetailGameDto;
import com.example.automappingex.model.dto.GameAddDto;
import com.example.automappingex.model.entity.Game;

import java.util.List;

public interface GameService {
    String addGame(GameAddDto gameDto);

    String editGame(Long id, List<String> commands);

    String deleteGame(Long id);

    List<AllGameDto> findTitleAndPriceOfAllGames();

    DetailGameDto findGameDetailsByTitle(String title);

    Game findGameByName(String gameName);
}
