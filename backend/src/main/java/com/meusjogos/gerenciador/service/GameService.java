package com.meusjogos.gerenciador.service;

import com.meusjogos.gerenciador.dto.GameDTO;

import java.util.List;

public interface GameService {
    List<GameDTO> findAllGames();

    GameDTO findGameById(long id);

    void deleteGameById(long id);

    GameDTO saveNewGame(GameDTO gameDTO);
}
