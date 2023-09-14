package com.jonispatented.cosmos_intruders.game_logic.entities;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.NoAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies.HostileMutualCollisionStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.SimpleDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.BulletMovementStrategy;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.IEntityRenderer;

public class Bullet extends Entity {

    public static final int WIDTH = 6, HEIGHT = 6;

    public Bullet(float x, float y, Direction direction, float speed,
                  GameEngine gameEngine, IEntityRenderer renderer, Alliance alliance) {
        super(x, y, WIDTH, HEIGHT, gameEngine, renderer,
                new BulletMovementStrategy(direction, speed),
                new NoAttackStrategy(), new SimpleDeathStrategy(null),
                new HostileMutualCollisionStrategy(alliance), alliance);
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
