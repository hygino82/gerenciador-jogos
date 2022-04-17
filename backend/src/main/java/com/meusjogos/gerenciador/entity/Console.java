package com.meusjogos.gerenciador.entity;

import com.meusjogos.gerenciador.dto.ConsoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_console")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Console implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    public Console(ConsoleDTO consoleDTO) {
        name = consoleDTO.getName();
    }
}
