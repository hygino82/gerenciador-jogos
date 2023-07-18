package dev.hygino.services;

import org.springframework.stereotype.Service;

import dev.hygino.dtos.GameDTO;
import dev.hygino.dtos.GameInsertDTO;
import dev.hygino.entities.Game;
import dev.hygino.repositories.GameRepository;

@Service
public class GameService {

	private final GameRepository repository;

	public GameService(GameRepository repository) {
		this.repository = repository;
	}

	public GameDTO insert(GameInsertDTO dto) {
		Game entity = new Game(dto);
		entity = repository.save(entity);

		return new GameDTO(entity);
	}

}
