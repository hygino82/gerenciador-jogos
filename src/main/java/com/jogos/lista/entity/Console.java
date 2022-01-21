package com.jogos.lista.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "console")
@Entity(name = "console")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    public Console(String name) {
        this.name = name;
    }

}
