package com.meusjogos.gerenciador.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meusjogos.gerenciador.dto.GameDTO;
import com.meusjogos.gerenciador.entity.Console;
import com.meusjogos.gerenciador.entity.Game;
import com.meusjogos.gerenciador.repository.ConsoleRepository;
import com.meusjogos.gerenciador.repository.GameRepository;
import com.meusjogos.gerenciador.service.exceptions.EntityNotFoundException;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private ConsoleRepository consoleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<GameDTO> findAllGames() {
		List<Game> gameList = gameRepository.findAll();
		List<GameDTO> listDto = new ArrayList<>();

		for (Game game : gameList) {
			GameDTO gameDTO = new GameDTO(game);
			listDto.add(gameDTO);
		}

		return listDto;
	}

	@Override // adicionado ecessao
	@Transactional(readOnly = true)
	public GameDTO findGameById(long id) {
		Optional<Game> obj = gameRepository.findById(id);
		Game entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new GameDTO(entity);
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

	@Override
	public List<GameDTO> findAllByMediaType(String mediaType) {
		var gameList = gameRepository.findAllByMediaTypeIgnoreCase(mediaType);
		return gameList.stream().map(GameDTO::new).collect(Collectors.toList());
	}
}
