package com.meusjogos.gerenciador.controller;

import com.meusjogos.gerenciador.dto.GameDTO;
import com.meusjogos.gerenciador.service.GameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping
    @ApiOperation(value = "Salvar um jogo")
    public GameDTO saveNewGame(@RequestBody GameDTO gameDTO) {
        return gameService.saveNewGame(gameDTO);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os jogos")
    public List<GameDTO> findAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encontrar um jogo pelo seu Id")
    public GameDTO findGameById(@PathVariable long id) {
        return gameService.findGameById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ApiOperation(value = "Remover um jogo pelo seu Id")
    public void deleteGameById(@PathVariable long id) {
        gameService.deleteGameById(id);
    }
}
