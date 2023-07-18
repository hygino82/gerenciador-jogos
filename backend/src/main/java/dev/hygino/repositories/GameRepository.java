package dev.hygino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hygino.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
