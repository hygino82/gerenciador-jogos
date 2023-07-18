package dev.hygino.dtos;

public record GameInsertDTO(
		String name, 
		String personalCode,
		String imageUrl, 
		String videoUrl, 
		String media,
		String console) {
}
