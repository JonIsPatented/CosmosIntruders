package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

public class BulletMovementStrategy implements IMovementStrategy {

    private Direction direction;
    private float speed;

    public BulletMovementStrategy(Direction direction, float speed) {
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public void move(Entity self, GameEngine gameEngine) {
        self.addX(speed * direction.x());
        self.addY(speed * direction.y());

        if (self.getX() > gameEngine.getWindowWidth()
                || self.getX() < 0
                || self.getY() > gameEngine.getWindowHeight()
                || self.getY() < 0)
            gameEngine.markEntityForRemoval(self);
    }

}
