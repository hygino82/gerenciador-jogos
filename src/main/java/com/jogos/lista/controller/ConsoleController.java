package com.jogos.lista.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jogos.lista.dto.ConsoleDto;
import com.jogos.lista.entity.Console;
import com.jogos.lista.service.ConsoleService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/console")
public class ConsoleController {
	@Autowired
	private ConsoleService consoleService;
	
	@PostMapping
	@ApiOperation(value = "Salvar um console")
	public ResponseEntity<Object> saveConsole(@RequestBody @Valid ConsoleDto consoleDto){
		if (consoleService.existsByName(consoleDto.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: o console já foi adicionado");
		}
		
		var consoleModel = new Console();
		BeanUtils.copyProperties(consoleDto, consoleModel);// faz a copia dos atributos de dto para model
		
		return ResponseEntity.status(HttpStatus.CREATED).body(consoleService.save(consoleModel));	
	}
	
	@GetMapping
	@ApiOperation(value = "Listar todos os consoles")
	public ResponseEntity<List<Console>> getAllParkingSpot() {
		return ResponseEntity.status(HttpStatus.OK).body(consoleService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Procurar um console pelo seu Id")
	public ResponseEntity<Object> findParkingSpotById(@PathVariable(value = "id") Long id) {
		Optional<Console> consoleOptional = consoleService.findById(id);
		if (!consoleOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado console com esse Id!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(consoleOptional.get());
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar um console usando Id")
	public ResponseEntity<Object> deleteConsoleById(@PathVariable(value = "id") Long id) {
		Optional<Console> consoleOptional = consoleService.findById(id);
		if (!consoleOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado console com esse Id!");
		}
		consoleService.delete(consoleOptional.get());

		return ResponseEntity.status(HttpStatus.OK).body("Console removido com sucesso!");
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar um console usando Id")
	public ResponseEntity<Object> updateParkingspotById(@PathVariable(value = "id") Long id,
			@RequestBody @Valid ConsoleDto consoleDto) {
		Optional<Console> consoleOptional = consoleService.findById(id);
		if (!consoleOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado console com esse Id!");
		}

		var consoleModel = new Console(); 
	
		BeanUtils.copyProperties(consoleDto, consoleModel);
		consoleModel.setId(consoleOptional.get().getId());

		return ResponseEntity.status(HttpStatus.OK).body(consoleService.save(consoleModel));
	}
	
}
