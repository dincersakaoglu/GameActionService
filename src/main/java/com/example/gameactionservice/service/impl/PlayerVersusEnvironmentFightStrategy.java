package com.example.gameactionservice.service.impl;

import com.example.gameactionservice.constants.Message;
import com.example.gameactionservice.service.ActionStrategy;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import com.example.gameactionservice.model.GameCharacter;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link ActionStrategy} for handling player versus environment fights.
 * This strategy compares the defense power of a character against a monster and determines the result.
 */
@Component
public class PlayerVersusEnvironmentFightStrategy implements ActionStrategy {
    /**
     * Processes the action of a player versus environment fight.
     *
     * @param action the action to process
     * @return the result of the fight
     */
    @Override
    public ActionResult process(Action action) {
        GameCharacter character = action.getCharacter1();
        GameCharacter monster = action.getCharacter2();

        if (character.getDefence() >= monster.getDefence()) {
            return new ActionResult(Message.CHARACTER_WINS);
        } else {
            return new ActionResult(Message.MONSTER_WINS);
        }
    }

   @Override
    public ActionType actionType() {
        return ActionType.PLAYER_VERSUS_ENVIRONMENT_FIGHT;
    }
}
