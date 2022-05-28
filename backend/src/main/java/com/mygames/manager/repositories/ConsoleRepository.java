package com.mygames.manager.repositories;

import com.mygames.manager.entities.Console;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<Console,Long> {
}
