package com.example.gameactionservice.service;

import com.example.gameactionservice.service.ActionService;
import com.example.gameactionservice.enums.ActionType;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;


public interface ActionStrategy extends ActionService {

    ActionResult process(Action action);
    ActionType actionType();

}
