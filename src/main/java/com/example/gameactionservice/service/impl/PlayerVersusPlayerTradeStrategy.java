package com.example.gameactionservice.service.impl;

import com.example.gameactionservice.service.ActionStrategy;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.exception.NotSupportedActionTypeException;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import org.springframework.stereotype.Component;

@Component
public class PlayerVersusPlayerTradeStrategy implements ActionStrategy {
    @Override
    public ActionResult process(Action action) {
        throw new NotSupportedActionTypeException("not supported yet");
    }

    @Override
    public ActionType actionType() {
        return ActionType.PLAYER_VERSUS_PLAYER_TRADE;
    }
}
