package com.jogos.lista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jogos.lista.entity.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long>{

	public boolean existsByName(String name);
}
