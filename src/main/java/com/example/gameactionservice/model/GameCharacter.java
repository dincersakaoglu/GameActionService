package com.example.gameactionservice.model;

import lombok.Data;

@Data
public class GameCharacter {

    private int attack;
    private int defence;

    public GameCharacter(int attack, int defence) {
        this.attack = attack;
        this.defence = defence;
    }

}
