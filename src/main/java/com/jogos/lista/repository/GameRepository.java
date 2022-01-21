package com.jogos.lista.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jogos.lista.entity.Game;

public interface GameRepository extends CrudRepository<Game, Long> {

	@Override
	List<Game> findAll();

}
