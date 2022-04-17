package com.meusjogos.gerenciador.service;

import com.meusjogos.gerenciador.dto.GameDTO;
import com.meusjogos.gerenciador.entity.Console;
import com.meusjogos.gerenciador.entity.Game;
import com.meusjogos.gerenciador.repository.ConsoleRepository;
import com.meusjogos.gerenciador.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    @Override
    public List<GameDTO> findAllGames() {
        List<Game> gameList = gameRepository.findAll();
        List<GameDTO> listDto = new ArrayList<>();

        for (Game game : gameList) {
            GameDTO gameDTO = new GameDTO(game);
            listDto.add(gameDTO);
        }

        return listDto;
    }

    @Override
    public GameDTO findGameById(long id) {
        var game = gameRepository.findById(id).orElse(null);

        assert game != null;
        return new GameDTO(game);
    }

    @Override
    public void deleteGameById(long id) {
        gameRepository.findById(id).ifPresent(game -> gameRepository.delete(game));
    }

    @Override
    public GameDTO saveNewGame(GameDTO gameDTO) {
        Console console = consoleRepository.findById(gameDTO.getConsoleId()).get();

        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setConsole(console);
        game.setMediaType(gameDTO.getMediaType());
        game.setPersonalCode(gameDTO.getPersonalCode());

        gameRepository.save(game);

        return new GameDTO(game);
    }

    @Override
    public List<GameDTO> findAllGamesByConsoleName(String consoleName) {
        var gameList = gameRepository.findAllByConsoleNameIgnoreCase(consoleName);

        return gameList.stream().map(GameDTO::new).collect(Collectors.toList());
    }
}
