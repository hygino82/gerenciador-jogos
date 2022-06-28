package com.meusjogos.gerenciador.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meusjogos.gerenciador.dto.ConsoleDTO;
import com.meusjogos.gerenciador.entity.Console;
import com.meusjogos.gerenciador.repository.ConsoleRepository;
import com.meusjogos.gerenciador.service.exceptions.EntityNotFoundException;

@Service
public class ConsoleService {

	@Autowired
	private ConsoleRepository repository;

	@Autowired
	private ModelMapper mapper;

	public List<ConsoleDTO> findAllConsoles() {
		List<Console> list = repository.findAll();
		List<ConsoleDTO> res = list.stream().map(x -> mapper.map(x, ConsoleDTO.class)).collect(Collectors.toList());
		return res;
	}

	public ConsoleDTO findConsoleById(Long id) {
		var console = repository.findById(id);

		if (!console.isPresent()) {
			throw new EntityNotFoundException("Console não encontrado");
		}

		return mapper.map(console, ConsoleDTO.class);
	}

	public ConsoleDTO saveNewConsole(ConsoleDTO consoleDTO) {
		Console console = repository.save(new Console(consoleDTO));

		return mapper.map(console, ConsoleDTO.class);
	}

	public void deleteConsoleById(Long id) {
		var console = repository.findById(id);
		console.ifPresent(value -> repository.delete(value));
	}

	public ConsoleDTO updateConsoleById(Long id, ConsoleDTO dto) {
		Console updateConsole;
		if (repository.findById(id).isPresent() && !dto.getName().strip().equals("")) {
			updateConsole = repository.getById(id);
			updateConsole.setName(dto.getName());
			repository.save(updateConsole);
			return mapper.map(updateConsole, ConsoleDTO.class);
		} else {
			throw new EntityNotFoundException("A entidade não existe ou o nome é inválido");
		}
	}

	public List<ConsoleDTO> findConsoleByName(String name) {
		var list = repository.buscarPorNome(name);
		
		List<ConsoleDTO> res = list.stream().map(x -> mapper.map(x, ConsoleDTO.class)).collect(Collectors.toList());
		return res;
	}
}
