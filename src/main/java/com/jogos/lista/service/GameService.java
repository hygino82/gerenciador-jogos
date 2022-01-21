package com.jogos.lista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogos.lista.entity.Game;
import com.jogos.lista.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public void save(Game game) {
		this.gameRepository.save(game);
	}

	public List<Game> findAll() {
		return this.gameRepository.findAll();
	}
}
