package com.meusjogos.gerenciador.dto;

import com.meusjogos.gerenciador.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {

    private Long id;
    private String name;
    private String consoleName;

    private Long consoleId;
    private String personalCode;
    private String mediaType;

    public GameDTO(Game game) {
        id = game.getId();
        name = game.getName();
        mediaType = game.getMediaType();
        personalCode = game.getPersonalCode();
        consoleName = game.getConsole().getName();
        consoleId = game.getId();
    }
}
