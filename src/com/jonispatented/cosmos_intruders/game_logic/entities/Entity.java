package com.jonispatented.cosmos_intruders.game_logic.entities;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.IAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies.ICollisionStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.IDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.IMovementStrategy;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.IEntityRenderer;

import java.awt.*;

public abstract class Entity {

    protected final GameEngine gameEngine;

    protected IEntityRenderer renderer;
    protected IMovementStrategy movementStrategy;
    protected IAttackStrategy attackStrategy;
    protected IDeathStrategy deathStrategy;
    protected ICollisionStrategy collisionStrategy;
    protected final Alliance alliance;

    protected float x, y, width, height;

    public Entity(float x, float y, float width, float height, GameEngine gameEngine,
                  IEntityRenderer renderer, IMovementStrategy movementStrategy,
                  IAttackStrategy attackStrategy, IDeathStrategy deathStrategy,
                  ICollisionStrategy collisionStrategy, Alliance alliance) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameEngine = gameEngine;
        this.renderer = renderer;
        this.movementStrategy = movementStrategy;
        this.attackStrategy = attackStrategy;
        this.deathStrategy = deathStrategy;
        this.collisionStrategy = collisionStrategy;
        this.alliance = alliance;
    }

    public void render(Graphics g) {
        renderer.render(this, g);
    }

    public void move() {
        movementStrategy.move(this, gameEngine);
    }

    public void attack() {
        attackStrategy.attack(this, gameEngine);
    }

    public void die() {
        deathStrategy.die(this, gameEngine);
    }

    public void collide() {
        collisionStrategy.collide(this, gameEngine);
    }

    public void addX(float dx) {
        x += dx;
    }

    public void addY(float dy) {
        y += dy;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public IMovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
}
