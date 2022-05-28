package com.mygames.manager.services;

import com.mygames.manager.dto.ConsoleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsoleService {
    Page<ConsoleDTO> findAllPaged(Pageable pageagle);

    ConsoleDTO findById(Long id);

    ConsoleDTO insert(ConsoleDTO dto);

    ConsoleDTO update(Long id, ConsoleDTO dto);

    void delete(Long id);
}
