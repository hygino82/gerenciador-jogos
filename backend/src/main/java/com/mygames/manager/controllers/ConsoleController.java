package com.mygames.manager.controllers;

import com.mygames.manager.dto.ConsoleDTO;
import com.mygames.manager.services.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleService service;

    @GetMapping
    public ResponseEntity<Page<ConsoleDTO>> findAll(Pageable pageagle) {
        Page<ConsoleDTO> page = service.findAllPaged(pageagle);

        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsoleDTO> findById(@PathVariable("id") Long id) {
        ConsoleDTO dto = service.findById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ConsoleDTO> insert(@RequestBody ConsoleDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsoleDTO> update(@PathVariable("id") Long id, @RequestBody ConsoleDTO dto) {
        dto = service.update(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ConsoleDTO> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
