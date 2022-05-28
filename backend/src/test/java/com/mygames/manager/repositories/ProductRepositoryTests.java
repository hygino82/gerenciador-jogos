package com.mygames.manager.repositories;

import com.mygames.manager.entities.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

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
}
