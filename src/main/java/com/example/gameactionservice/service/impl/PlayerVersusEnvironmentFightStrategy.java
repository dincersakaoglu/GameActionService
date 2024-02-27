package com.example.gameactionservice.service.impl;

import com.example.gameactionservice.service.ActionStrategy;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import com.example.gameactionservice.model.GameCharacter;
import org.springframework.stereotype.Component;

@Component
public class PlayerVersusEnvironmentFightStrategy implements ActionStrategy {
    @Override
    public ActionResult process(Action action) {
        GameCharacter character = action.getCharacter1();
        GameCharacter monster = action.getCharacter2();

        if (character.getDefence() >= monster.getDefence()) {
            return new ActionResult("Character wins");
        } else {
            return new ActionResult("Monster wins");
        }
    }

   @Override
    public ActionType actionType() {
        return ActionType.PLAYER_VERSUS_ENVIRONMENT_FIGHT;
    }
}
