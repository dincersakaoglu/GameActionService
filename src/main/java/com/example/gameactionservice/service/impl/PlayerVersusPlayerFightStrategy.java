package com.example.gameactionservice.service.impl;

import com.example.gameactionservice.constants.Message;
import com.example.gameactionservice.service.ActionStrategy;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import com.example.gameactionservice.model.GameCharacter;
import org.springframework.stereotype.Component;


/**
 * Implementation of {@link ActionStrategy} for handling player versus player fights.
 * This strategy compares the attack power of two characters and determines the winner.
 */
@Component
public class PlayerVersusPlayerFightStrategy implements ActionStrategy {
    /**
     * Processes the action of a player versus player fight.
     *
     * @param action the action to process
     * @return the result of the fight
     */
    @Override
    public ActionResult  process(Action action) {
        GameCharacter CharacterOne = action.getCharacter1();
        GameCharacter CharacterTwo = action.getCharacter2();

        if (CharacterOne.getAttack() >= CharacterTwo.getAttack()) {
            return new ActionResult(Message.CHARACTER_1_WINS);
        } else {
            return new ActionResult(Message.CHARACTER_2_WINS);
        }
    }
    @Override
    public ActionType actionType() {
        return ActionType.PLAYER_VERSUS_PLAYER_FIGHT;
    }
}
