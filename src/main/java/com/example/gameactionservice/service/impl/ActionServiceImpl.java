package com.example.gameactionservice.service.impl;

import com.example.gameactionservice.constants.Message;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import com.example.gameactionservice.service.ActionService;
import com.example.gameactionservice.service.ActionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


@Service
@Primary
public class ActionServiceImpl implements ActionService {

    private final Map<ActionType, ActionStrategy> handlerMap;

    @Autowired
    public ActionServiceImpl(List<ActionStrategy> actionStrategies) {
        this.handlerMap = initializeHandlerMap(actionStrategies);
    }

    private Map<ActionType, ActionStrategy> initializeHandlerMap(List<ActionStrategy> actionStrategies) {
        Map<ActionType, ActionStrategy> actionTypeActionStrategyMap = new EnumMap<>(ActionType.class);
        actionStrategies.forEach(strategy -> actionTypeActionStrategyMap.put(strategy.actionType(), strategy));
        return actionTypeActionStrategyMap;
    }

    @Override
    public ActionResult process(Action action) {
        ActionType actionType = action.getType();
        ActionStrategy actionStrategy = handlerMap.get(actionType);
        if (actionStrategy == null) {
            throw new IllegalArgumentException(Message.NO_HANDLER_FOUND_FOR_ACTION_TYPE + actionType);
        }
        return actionStrategy.process(action);
    }
}
