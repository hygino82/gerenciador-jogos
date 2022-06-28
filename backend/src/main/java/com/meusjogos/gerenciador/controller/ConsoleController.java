package com.meusjogos.gerenciador.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meusjogos.gerenciador.dto.ConsoleDTO;
import com.meusjogos.gerenciador.service.ConsoleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/console")
public class ConsoleController {

	@Autowired
	private ConsoleService consoleService;

	@GetMapping
	@ApiOperation(value = "Listar todos os consoles")
	public List<ConsoleDTO> findAllConsoles() {
		return consoleService.findAllConsoles();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Procurar um console pelo seu Id")
	public ConsoleDTO findConsoleById(@PathVariable Long id) {
		return consoleService.findConsoleById(id);
	}

	@PostMapping
	@ApiOperation(value = "Salvar um console")
	public ConsoleDTO saveNewConsole(@RequestBody ConsoleDTO consoleDTO) {
		return consoleService.saveNewConsole(consoleDTO);
	}

	@DeleteMapping("/{id}")
	@Transactional
	@ApiOperation(value = "Remover um console usando Id")
	public void deleteConsoleById(@PathVariable Long id) {
		consoleService.deleteConsoleById(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar um console usando Id")
	public ConsoleDTO updateConsoleById(@PathVariable Long id, @RequestBody ConsoleDTO dto) {
		return consoleService.updateConsoleById(id, dto);
	}

	@GetMapping("/name")
	@ApiOperation(value = "Procurar um console pelo seu Nome")
	public List<ConsoleDTO> findConsoleByName(@RequestParam(name = "name", defaultValue = "a") String name) {
		return consoleService.findConsoleByName(name);
	}
}
