package com.meusjogos.gerenciador.service;

import com.meusjogos.gerenciador.dto.ConsoleDTO;
import com.meusjogos.gerenciador.entity.Console;
import com.meusjogos.gerenciador.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Override
    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    @Override
    public Console findConsoleById(long id) {
        return consoleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteConsoleById(long id) {
        var console = consoleRepository.findById(id);
        console.ifPresent(value -> consoleRepository.delete(value));
    }

    @Override
    public void updateConsoleById(long id, Console console) {
        Console updateConsole;
        if (consoleRepository.findById(id).isPresent() && !console.getName().equals("")) {
            updateConsole = consoleRepository.findById(id).get();
            updateConsole.setName(console.getName());
            consoleRepository.save(updateConsole);
        }
    }

    @Override
    public Console saveNewConsole(ConsoleDTO consoleDTO) {
        return consoleRepository.save(new Console(consoleDTO));
    }

    public boolean existsByName(String name) {
        return consoleRepository.existsByName(name);
    }

    @Override
    public List<Console> findConsoleByName(String name) {
        return consoleRepository.findAllByNameStartsWithIgnoreCase(name);
    }
}
