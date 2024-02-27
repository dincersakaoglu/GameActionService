package com.example.gameactionservice.model;

import com.example.gameactionservice.enums.ActionType;
import lombok.Data;


@Data
public class Action {

    private ActionType type;
    private GameCharacter character1;
    private GameCharacter character2;

    public Action(ActionType type, GameCharacter character1, GameCharacter character2) {
        this.type = type;
        this.character1 = character1;
        this.character2 = character2;
    }
}
