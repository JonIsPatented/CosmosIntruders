package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

public interface IDeathStrategy {

    void die(Entity self, GameEngine gameEngine);

}
