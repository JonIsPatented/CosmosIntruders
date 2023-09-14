package com.jonispatented.cosmos_intruders.game_logic.entities.creatures.enemies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Alliance;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.IAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.NoAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies.ICollisionStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies.NoCollisionStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.IDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.SimpleDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.IMovementStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.NoMovementStrategy;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.IEntityRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.StillSpriteRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

public class Enemy extends Entity {

    private int pointValue;

    private Enemy(float x, float y, float width, float height,
                 GameEngine gameEngine, IEntityRenderer renderer,
                 IMovementStrategy movementStrategy, IAttackStrategy attackStrategy,
                 IDeathStrategy deathStrategy, ICollisionStrategy collisionStrategy, int pointValue) {
        super(x, y, width, height, gameEngine, renderer,
                movementStrategy, attackStrategy, deathStrategy, collisionStrategy, Alliance.ENEMY);
        this.pointValue = pointValue;
    }

    public int getPointValue() {
        return pointValue;
    }

    public static class Builder {

        private final Enemy enemy;

        public Builder(GameEngine gameEngine) {
            enemy = new Enemy(0,0,0,0, gameEngine,
                    null, null, null,
                    null, null, 0);
        }

        public Builder setX(float x) {
            enemy.x = x;
            return this;
        }

        public Builder setY(float y) {
            enemy.y = y;
            return this;
        }

        public Builder setWidth(float width) {
            enemy.width = width;
            return this;
        }

        public Builder setHeight(float height) {
            enemy.height = height;
            return this;
        }

        public Builder setRenderer(IEntityRenderer renderer) {
            enemy.renderer = renderer;
            return this;
        }

        public Builder setMovementStrategy(IMovementStrategy movementStrategy) {
            enemy.movementStrategy = movementStrategy;
            return this;
        }

        public Builder setAttackStrategy(IAttackStrategy attackStrategy) {
            enemy.attackStrategy = attackStrategy;
            return this;
        }

        public Builder setCollisionStrategy(ICollisionStrategy collisionStrategy) {
            enemy.collisionStrategy = collisionStrategy;
            return this;
        }

        public Builder setDeathStrategy(IDeathStrategy deathStrategy) {
            enemy.deathStrategy = deathStrategy;
            return this;
        }

        public Builder setPointValue(int pointValue) {
            enemy.pointValue = pointValue;
            return this;
        }

        public Enemy build() {
            if (enemy.renderer == null)
                enemy.renderer = new StillSpriteRenderer(Sprite.BASIC_ENEMY);
            if (enemy.movementStrategy == null)
                enemy.movementStrategy = new NoMovementStrategy();
            if (enemy.attackStrategy == null)
                enemy.attackStrategy = new NoAttackStrategy();
            if (enemy.collisionStrategy == null)
                enemy.collisionStrategy = new NoCollisionStrategy();
            if (enemy.deathStrategy == null)
                enemy.deathStrategy = new SimpleDeathStrategy(SoundClip.POINT);
            if (enemy.width == 0)
                enemy.width = 20;
            if (enemy.height == 0)
                enemy.height = 20;
            return enemy;
        }

    }

}
