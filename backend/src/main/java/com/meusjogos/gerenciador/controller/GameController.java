package com.meusjogos.gerenciador.controller;

import com.meusjogos.gerenciador.dto.GameDTO;
import com.meusjogos.gerenciador.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameDTO> findAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping("/{id}")
    public GameDTO findGameById(@PathVariable long id) {
        return gameService.findGameById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGameById(@PathVariable long id) {
        gameService.deleteGameById(id);
    }

    @PostMapping
    public GameDTO saveNewGame(@RequestBody GameDTO gameDTO){
        return gameService.saveNewGame(gameDTO);
    }
}
