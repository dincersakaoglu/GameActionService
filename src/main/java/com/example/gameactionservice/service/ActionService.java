package com.example.gameactionservice.service;

import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;

public interface ActionService {

    ActionResult process(Action action);

}
