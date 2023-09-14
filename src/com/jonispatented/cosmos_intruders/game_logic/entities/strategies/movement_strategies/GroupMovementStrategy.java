package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

import java.util.List;

public class GroupMovementStrategy implements IMovementStrategy {

    private float speed;

    private final List<Entity> alliesBlock;
    private Direction moveDirection = Direction.RIGHT;
    private boolean hasMovedThisCycle = false;

    public GroupMovementStrategy(List<Entity> alliesBlock, float speed) {
        this.alliesBlock = alliesBlock;
        this.speed = speed;
    }

    @Override
    public void move(Entity e, GameEngine gameEngine) {

        if (alliesBlock.stream()
                .noneMatch(entity -> ((GroupMovementStrategy)entity.getMovementStrategy()).hasMovedThisCycle))
            checkBorders(gameEngine);

        e.addX(speed * moveDirection.x());
        hasMovedThisCycle = true;

        if (alliesBlock.stream().allMatch(entity ->
                ((GroupMovementStrategy)entity.getMovementStrategy()).hasMovedThisCycle))
            alliesBlock.forEach(entity ->
                    ((GroupMovementStrategy)entity.getMovementStrategy()).hasMovedThisCycle = false);
    }

    public void setMoveDirection(Direction moveDirection) {
        this.moveDirection = moveDirection;
    }

    private void checkBorders(GameEngine gameEngine) {
        for (Entity entity : alliesBlock) {
            if (entity.getX() < 10 && moveDirection == Direction.LEFT) {
                for (Entity enemy : alliesBlock) {
                    ((GroupMovementStrategy)enemy.getMovementStrategy()).setMoveDirection(Direction.RIGHT);
                    enemy.addY(20);
                }
                break;
            }
            if (entity.getX() > gameEngine.getWindowWidth() - 10 - entity.getWidth()
                    && moveDirection == Direction.RIGHT) {
                for (Entity enemy : alliesBlock) {
                    ((GroupMovementStrategy)enemy.getMovementStrategy()).setMoveDirection(Direction.LEFT);
                    enemy.addY(20);
                }
                break;
            }
        }
    }

}
