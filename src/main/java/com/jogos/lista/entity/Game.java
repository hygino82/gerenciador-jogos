package com.jogos.lista.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "games")
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;

    private String personalCode;
    private String imageUrl;
    private Integer year;
    
	public Game(String name, Console console, String personalCode, String imageUrl, Integer year) {
		this.name = name;
		this.console = console;
		this.personalCode = personalCode;
		this.imageUrl = imageUrl;
		this.year = year;
	}
    
    
}
