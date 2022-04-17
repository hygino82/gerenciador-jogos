package com.meusjogos.gerenciador.repository;

import com.meusjogos.gerenciador.entity.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    boolean existsByName(String name);
}
