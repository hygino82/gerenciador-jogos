package com.meusjogos.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meusjogos.gerenciador.entity.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    
	boolean existsByName(String name);
    List<Console> findAllByNameContainingIgnoreCase(String name);
    
    @Query(nativeQuery = true, value ="SELECT console.id, console.name "
    		+ "FROM tb_console AS console "
    		+ "WHERE UPPER(console.name) LIKE %UPPER(:name)%")
    List<Console> buscarPorNome(String name);
}
