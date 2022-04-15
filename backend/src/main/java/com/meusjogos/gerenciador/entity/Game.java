package com.meusjogos.gerenciador.entity;

import com.meusjogos.gerenciador.dto.GameDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_games")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;

    private String personalCode;
    private String mediaType;

    public Game(String name, Console console, String personalCode, String mediaType) {
        this.name = name;
        this.console = console;
        this.personalCode = personalCode;
        this.mediaType = mediaType;
    }
}
