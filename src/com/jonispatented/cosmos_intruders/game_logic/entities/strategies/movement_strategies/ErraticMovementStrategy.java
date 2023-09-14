package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

import java.util.Random;

public class ErraticMovementStrategy implements IMovementStrategy {

    private final Random rand;
    private Direction moveDirection = Direction.LEFT;
    private float speed;

    public ErraticMovementStrategy(float speed) {
        this.speed = speed;
        rand = new Random();
    }

    @Override
    public void move(Entity self, GameEngine gameEngine) {
        self.addX(speed * moveDirection.x());
        if (self.getX() < 10 && moveDirection == Direction.LEFT) {
            moveDirection = Direction.RIGHT;
        }
        else if (self.getX() > gameEngine.getWindowWidth() - 10 - self.getWidth()
                && moveDirection == Direction.RIGHT) {
            moveDirection = Direction.LEFT;
        }
        else if (rand.nextInt(GameEngine.TPS_SET) == 0)
            self.addY(20);
    }

}
