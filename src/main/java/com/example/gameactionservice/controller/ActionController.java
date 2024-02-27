package com.example.gameactionservice.controller;

import com.example.gameactionservice.service.ActionContext;
import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
@RequestMapping("/action")
public class ActionController {

    private final ActionContext actionContext;

    @PostMapping()
    public ActionResult process(@RequestBody Action action) {
        return actionContext.process(action);
    }

}
