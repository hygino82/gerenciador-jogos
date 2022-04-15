package com.meusjogos.gerenciador.service;

import com.meusjogos.gerenciador.entity.Console;

import java.util.List;
public interface ConsoleService {
    List<Console> findAllConsoles();

    Console findConsoleById(long id);

    void deleteConsoleById(long id);

    void updateConsoleById(long id, Console console);

    Console saveNewConsole(Console console);
}
