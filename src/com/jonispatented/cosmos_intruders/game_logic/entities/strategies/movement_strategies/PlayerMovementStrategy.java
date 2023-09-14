package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.ui.player_input.Input;

import java.util.concurrent.ConcurrentHashMap;

public class PlayerMovementStrategy implements IMovementStrategy {

    private float speed;

    public PlayerMovementStrategy(float speed) {
        this.speed = speed;
    }

    @Override
    public void move(Entity self, GameEngine gameEngine) {
        ConcurrentHashMap<Input, Boolean> inputs = gameEngine.getPlayerInputs();
        if (inputs.get(Input.LEFT))
            self.addX(-speed);
        if (inputs.get(Input.RIGHT))
            self.addX(speed);
        self.setX(Math.min(Math.max(0, self.getX()), gameEngine.getWindowWidth() - self.getWidth()));
    }

}
