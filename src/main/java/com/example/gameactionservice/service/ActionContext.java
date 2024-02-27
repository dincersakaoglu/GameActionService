package com.example.gameactionservice.service;

import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@Component
public class ActionContext {
    private final Map<ActionType,ActionStrategy> processActionByType;

    public ActionResult process(Action action) {

        ActionStrategy actionStrategy = processActionByType.getOrDefault(action.getType(), null);

        return actionStrategy.process(action);
    }
}
