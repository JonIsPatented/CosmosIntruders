package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

public interface ICollisionStrategy {

    void collide(Entity self, GameEngine gameEngine);

}
