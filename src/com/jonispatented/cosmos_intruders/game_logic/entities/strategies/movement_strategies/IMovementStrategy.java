package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

public interface IMovementStrategy {

    void move(Entity e, GameEngine gameEngine);

}
