package com.example.gameactionservice.controller;


import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;
import com.example.gameactionservice.service.ActionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
@RequestMapping("/action")
public class ActionController {

    private final ActionService actionService;

    @PostMapping()
    public ActionResult process(@RequestBody Action action) {
        return actionService.process(action);
    }

}
