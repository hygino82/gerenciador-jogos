package dev.hygino.dtos;

import dev.hygino.entities.Game;
import dev.hygino.entities.enums.Console;
import dev.hygino.entities.enums.MediaType;

public record GameDTO(
		Long id,
		String name, 
		String personalCode,
		String imageUrl, 
		String videoUrl, 
		MediaType media,
		Console console) {
	
	public GameDTO(Game entity) {
		this(
				entity.getId(),
				entity.getName(),
				entity.getPersonalCode(),
				entity.getImageUrl(),
				entity.getVideoUrl(),
				entity.getMedia(),
				entity.getConsole()
			);
	}
}
