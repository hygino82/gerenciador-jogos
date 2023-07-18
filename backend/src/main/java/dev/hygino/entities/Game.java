package dev.hygino.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import dev.hygino.dtos.GameInsertDTO;
import dev.hygino.entities.enums.Console;
import dev.hygino.entities.enums.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String personalCode;
	private String imageUrl;
	private String videoUrl;
	private MediaType media;
	private Console console;
	private Instant createDate;
	private Instant updateDate;

	public Game() {
	}

	public Game(GameInsertDTO dto) {
		name = dto.name();
		personalCode = dto.personalCode();
		imageUrl = dto.imageUrl();
		videoUrl = dto.videoUrl();
		media = MediaType.valueOf(dto.media().toUpperCase());
		console = Console.valueOf(dto.console().toUpperCase());
		createDate = Instant.now();
		updateDate = Instant.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public MediaType getMedia() {
		return media;
	}

	public void setMedia(MediaType media) {
		this.media = media;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public Instant getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
}
