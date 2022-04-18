package com.meusjogos.gerenciador.repository;

import com.meusjogos.gerenciador.entity.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    boolean existsByName(String name);
    List<Console> findAllByNameContainsIgnoreCase(String name);
    List<Console> findAllByNameStartsWithIgnoreCase(String name);
    List<Console> findAllByNameContains(String name);
    List<Console> findAllByNameIgnoreCase(String name);
}
