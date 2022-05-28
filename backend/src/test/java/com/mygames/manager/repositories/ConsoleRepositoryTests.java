package com.mygames.manager.repositories;

import com.mygames.manager.entities.Console;
import com.mygames.manager.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ConsoleRepositoryTests {

    @Autowired
    private ConsoleRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalConsoles;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalConsoles = 14L;
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalConsoleWhenIdExists() {
        Optional<Console> result = repository.findById(existingId);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Nintendo", result.get().getName());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExists() {
        Optional<Console> result = repository.findById(nonExistingId);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void insertShouldPersistWithAutoIncrementWhenIdIsNull() {
        Console console = Factory.createConsole();
        console.setId(null);

        console = repository.save(console);

        Assertions.assertNotNull(console.getId());// testa se o id é nulo
        Assertions.assertEquals(countTotalConsoles + 1L, console.getId());// verifica se o id gerado é 14+1
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);

        Optional<Console> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());// verifica se o valor está presente
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
