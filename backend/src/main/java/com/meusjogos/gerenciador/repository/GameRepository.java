package com.meusjogos.gerenciador.repository;

import com.meusjogos.gerenciador.dto.GameDTO;
import com.meusjogos.gerenciador.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByConsoleNameIgnoreCase(String consoleName);
    List<Game> findAllByMediaTypeIgnoreCase(String mediaType);
}
