package com.mygames.manager.dto;

import com.mygames.manager.entities.Console;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ConsoleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public ConsoleDTO() {
    }

    public ConsoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ConsoleDTO(Console entity) {
        id = entity.getId();
        name = entity.getName();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleDTO that = (ConsoleDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
