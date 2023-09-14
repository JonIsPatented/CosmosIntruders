package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

public class SimpleMovementStrategy implements IMovementStrategy {

    private Direction moveDirection = Direction.LEFT;
    private float speed;

    public SimpleMovementStrategy(float speed) {
        this.speed = speed;
    }

    @Override
    public void move(Entity self, GameEngine gameEngine) {
        self.addX(speed * moveDirection.x());
        if (self.getX() < 10 && moveDirection == Direction.LEFT) {
            self.addY(20);
            moveDirection = Direction.RIGHT;
        }
        else if (self.getX() > gameEngine.getWindowWidth() - 10 - self.getWidth()
                && moveDirection == Direction.RIGHT) {
            self.addY(20);
            moveDirection = Direction.LEFT;
        }
    }

}
