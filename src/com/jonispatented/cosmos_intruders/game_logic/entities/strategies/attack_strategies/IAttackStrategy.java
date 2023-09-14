package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

public interface IAttackStrategy {

    void attack(Entity e, GameEngine gameEngine);

}
