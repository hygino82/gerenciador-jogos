package dev.hygino.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hygino.dtos.GameDTO;
import dev.hygino.dtos.GameInsertDTO;
import dev.hygino.services.GameService;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

	private final GameService service;

	public GameController(GameService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<GameDTO> insert(GameInsertDTO dto) {
		return ResponseEntity.status(200).body(service.insert(dto));
	}
}
