package com.example.gameactionservice.service;

import com.example.gameactionservice.model.Action;
import com.example.gameactionservice.model.ActionResult;

public interface ActionService {

    /**
     * <pre>
     * Overview:
     *    This microservice processes an online fantasy game actions like fight, buff, trade, etc.
     *    Communication channel is REST. Input DTO is {@link Action} and output DTO is {@link ActionResult}.
     *
     * TODO:
     * - implement game logic behind {@link ActionService#process(Action)} method based on requirements below.
     *    Notes:
     *    - It is NOT allowed to change {@link ActionService} interface.
     *    - It is NOT allowed to change the general logic of this microservice. It must process actions.
     *    - It is allowed to change classes, beans, interfaces (except {@link ActionService} interface), REST endpoint,
     *      naming, packages, etc in this microservice if needed.
     *    - It is allowed to create new classes, beans, interfaces, REST endpoints, packages, etc
     *      in this microservice if needed.
     *
     * Requirements:
     * - {@link ActionType#PLAYER_VERSUS_PLAYER_FIGHT} processing is required.
     * - {@link ActionType#PLAYER_VERSUS_ENVIRONMENT_FIGHT} processing is required.
     *    - Sending "not supported yet" for other action types from {@link ActionType}.
     * - Fight winner is calculated based on the following rules:
     *    - if action is PvP {@link ActionType#PLAYER_VERSUS_PLAYER_FIGHT}:
     *        - Character 1 will win if Character 1 attack >= Character 2 attack ({@link GameCharacter#getAttack()})
     *        - Character 2 will win if Character 1 attack < Character 2 attack ({@link GameCharacter#getAttack()})
     *    - if action is PvE {@link ActionType#PLAYER_VERSUS_ENVIRONMENT_FIGHT}:
     *        - Character will win if character defence >= monster defence ({@link GameCharacter#getDefence()})
     *        - Monster will win if character defence < monster defence ({@link GameCharacter#getDefence()})
     * - No Input DTO {@link Action} validation is needed. It is assumed that the DTO is not nullable and
     *   it has all valid fields.
     * - Unit tests are not required.
     * - Logging is not required.
     * - This spring microservice is able to run successfully to process REST calls.
     * - Clean implementation would be appreciated.
     * - Implementation open for future extensions of other {@link ActionType} would be appreciated.
     *
     * </pre>
     */

    ActionResult process(Action action);

}
