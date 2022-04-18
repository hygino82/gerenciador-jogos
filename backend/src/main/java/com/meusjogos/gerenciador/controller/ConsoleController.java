package com.meusjogos.gerenciador.controller;

import com.meusjogos.gerenciador.dto.ConsoleDTO;
import com.meusjogos.gerenciador.entity.Console;
import com.meusjogos.gerenciador.service.ConsoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/console")
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @PostMapping
    @ApiOperation(value = "Salvar um console")
    public Console saveNewConsole(@RequestBody ConsoleDTO consoleDTO) {
        return consoleService.saveNewConsole(consoleDTO);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos os consoles")
    public List<Console> findAllConsoles() {
        return consoleService.findAllConsoles();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Procurar um console pelo seu Id")
    public Console findConsoleById(@PathVariable long id) {
        return consoleService.findConsoleById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ApiOperation(value = "Remover um console usando Id")
    public void deleteConsoleById(@PathVariable long id) {
        consoleService.deleteConsoleById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar um console usando Id")
    public void updateConsoleById(@PathVariable long id, @RequestBody Console console) {
        consoleService.updateConsoleById(id, console);
    }

    @GetMapping("name/{name}")
    @ApiOperation(value = "Procurar um console pelo seu Nome")
    public List<Console> findConsoleByName(@PathVariable String name) {
        return consoleService.findConsoleByName(name);
    }
}
