package com.jogos.lista.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.jogos.lista.entity.Console;
import com.jogos.lista.repository.ConsoleRepository;

@Service
public class ConsoleService {

	@Autowired
	private ConsoleRepository consoleRepository;

	public List<Console> getConsoleList() {
		Iterable<Console> consoleIterable = this.consoleRepository.findAll();
		return Streamable.of(consoleIterable).toList();

	}

	public boolean existsByName(String name) {
		return consoleRepository.existsByName(name);
	}

	@Transactional
	public Console save(Console consoleModel) {
		return consoleRepository.save(consoleModel);
	}

	public List<Console> findAll() {
		return consoleRepository.findAll();
	}

	public Optional<Console> findById(Long id) {
		return consoleRepository.findById(id);
	}

	@Transactional
	public void delete(Console console) {
		consoleRepository.delete(console);		
	}
}
