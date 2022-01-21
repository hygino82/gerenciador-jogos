package com.jogos.lista.service;

import java.util.List;

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
}
