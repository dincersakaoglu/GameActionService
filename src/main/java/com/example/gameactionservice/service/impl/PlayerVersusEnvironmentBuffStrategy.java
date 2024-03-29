package com.example.gameactionservice.service.impl;

import com.example.gameactionservice.constants.Message;
import com.example.gameactionservice.service.ActionStrategy;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.exception.NotSupportedActionTypeException;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import org.springframework.stereotype.Component;

@Component
public class PlayerVersusEnvironmentBuffStrategy implements ActionStrategy {
    @Override
    public ActionResult process(Action action) {
        throw new NotSupportedActionTypeException(Message.NOT_SUPPORTED_YET);
    }

   @Override
    public ActionType actionType() {
        return ActionType.PLAYER_VERSUS_ENVIRONMENT_BUFF;
    }
}
