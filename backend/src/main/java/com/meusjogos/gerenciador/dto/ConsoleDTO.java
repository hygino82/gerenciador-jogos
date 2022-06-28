package com.meusjogos.gerenciador.dto;

import com.meusjogos.gerenciador.entity.Console;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ConsoleDTO {

	private Long id;
	private String name;

	public ConsoleDTO(Console entity) {
		id = entity.getId();
		name = entity.getName();
	}
}
