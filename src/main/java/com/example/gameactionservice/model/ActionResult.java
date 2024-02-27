package com.example.gameactionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ActionResult {

    private final Object result;

}
