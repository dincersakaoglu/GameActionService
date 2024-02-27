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

/**
 * Implementation of {@link ActionService} interface.
 * This service handles various types of actions by delegating to corresponding {@link ActionStrategy} implementations.
 */
@Service
@Primary
public class ActionServiceImpl implements ActionService {

    private final Map<ActionType, ActionStrategy> handlerMap;

    /**
     * Constructs a new ActionServiceImpl instance with the specified action strategies.
     *
     * @param actionStrategies the list of action strategies to initialize the handler map
     */
    @Autowired
    public ActionServiceImpl(List<ActionStrategy> actionStrategies) {
        this.handlerMap = initializeHandlerMap(actionStrategies);
    }

    /**
     * Initializes the handler map with the provided action strategies.
     *
     * @param actionStrategies the list of action strategies
     * @return the initialized handler map
     */
    private Map<ActionType, ActionStrategy> initializeHandlerMap(List<ActionStrategy> actionStrategies) {
        Map<ActionType, ActionStrategy> actionTypeActionStrategyMap = new EnumMap<>(ActionType.class);
        actionStrategies.forEach(strategy -> actionTypeActionStrategyMap.put(strategy.actionType(), strategy));
        return actionTypeActionStrategyMap;
    }

    /**
     * Processes the given action by delegating to the corresponding action strategy.
     *
     * @param action the action to process
     * @return the result of processing the action
     * @throws IllegalArgumentException if no handler is found for the action type
     */
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
