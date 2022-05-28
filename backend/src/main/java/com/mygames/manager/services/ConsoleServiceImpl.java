package com.mygames.manager.services;

import com.mygames.manager.dto.ConsoleDTO;
import com.mygames.manager.entities.Console;
import com.mygames.manager.repositories.ConsoleRepository;
import com.mygames.manager.services.exception.DatabaseException;
import com.mygames.manager.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	
    @Autowired
    private ConsoleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<ConsoleDTO> findAllPaged(Pageable pageagle) {
        Page<Console> page = repository.findAll(pageagle);

        return page.map(x -> new ConsoleDTO(x));
    }

    @Override
    @Transactional(readOnly = true)
    public ConsoleDTO findById(Long id) {
        Optional<Console> obj = repository.findById(id);
        Console entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ConsoleDTO(entity);
    }

    @Override
    public ConsoleDTO insert(ConsoleDTO dto) {
        Console entity = new Console();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ConsoleDTO(entity);
    }

    @Override
    @Transactional
    public ConsoleDTO update(Long id, ConsoleDTO dto) {
        try {
            Console entity = repository.getOne(id);
            // instancia um objeto provisório
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new ConsoleDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }


}
