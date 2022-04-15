package com.meusjogos.gerenciador.controller;

import com.meusjogos.gerenciador.entity.Console;
import com.meusjogos.gerenciador.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/console")
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @GetMapping
    public List<Console> findAllConsoles() {
        return consoleService.findAllConsoles();
    }

    @GetMapping("/{id}")
    public Console findConsoleById(@PathVariable long id) {
        return consoleService.findConsoleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConsoleById(@PathVariable long id) {
        consoleService.deleteConsoleById(id);
    }

    @PutMapping("/{id}")
    public void updateConsoleById(@PathVariable long id, @RequestBody Console console) {
        consoleService.updateConsoleById(id, console);
    }

    @PostMapping
    public Console saveNewConsole(@RequestBody Console console){
        return consoleService.saveNewConsole(console);
    }
}
