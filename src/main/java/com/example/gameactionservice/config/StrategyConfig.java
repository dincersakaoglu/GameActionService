package com.example.gameactionservice.config;

import com.example.gameactionservice.service.ActionStrategy;
import com.example.gameactionservice.enums.ActionType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class StrategyConfig {
    private final List<ActionStrategy> actionStrategies;

    @Bean
    public Map<ActionType, ActionStrategy> processActionByType() {
        Map<ActionType, ActionStrategy> processByType = new EnumMap<>(ActionType.class);
        actionStrategies.forEach(actionStrategy -> processByType.put(actionStrategy.actionType(), actionStrategy));
        return processByType;
    }

}
