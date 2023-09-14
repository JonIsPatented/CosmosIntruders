package com.jonispatented.cosmos_intruders.game_logic.entities.creatures.enemies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Alliance;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.BasicShootingAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.NoAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies.HostileMutualCollisionStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.EggDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.ExplosionDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.SimpleDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.ErraticMovementStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.GroupMovementStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.SimpleMovementStrategy;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.*;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

import java.util.ArrayList;

public enum EnemyFactory {

    BASIC_SHOOTER(
            gameEngine -> new Enemy.Builder(gameEngine)

                    .setX(30).setY(Util.MARGIN_TOP)
                    .setWidth(32).setHeight(32)
                    .setPointValue(300)

                    .setRenderer(new StillSpriteRenderer(Sprite.BASIC_SHOOTER))
                    .setMovementStrategy(new SimpleMovementStrategy(0.85f))
                    .setAttackStrategy(new BasicShootingAttackStrategy())
                    .setCollisionStrategy(new HostileMutualCollisionStrategy(Alliance.ENEMY))
                    .setDeathStrategy(new SimpleDeathStrategy(SoundClip.POINT))

                    .build()
    ),
    ERRATIC_SHOOTER(
            gameEngine -> new Enemy.Builder(gameEngine)

                    .setX(30).setY(Util.MARGIN_TOP)
                    .setWidth(32).setHeight(32)
                    .setPointValue(400)

                    .setRenderer(new StillSpriteRenderer(Sprite.ERRATIC_SHOOTER))
                    .setMovementStrategy(new ErraticMovementStrategy(1.1f))
                    .setAttackStrategy(new BasicShootingAttackStrategy())
                    .setCollisionStrategy(new HostileMutualCollisionStrategy(Alliance.ENEMY))
                    .setDeathStrategy(new SimpleDeathStrategy(SoundClip.POINT))

                    .build()
    ),
    BASIC_EXPLODER(
            gameEngine -> new Enemy.Builder(gameEngine)

                    .setX(30).setY(Util.MARGIN_TOP)
                    .setWidth(32).setHeight(32)
                    .setPointValue(600)

                    .setRenderer(new StillSpriteRenderer(Sprite.BASIC_EXPLODER))
                    .setMovementStrategy(new SimpleMovementStrategy(1.4f))
                    .setCollisionStrategy(new HostileMutualCollisionStrategy(Alliance.ENEMY))
                    .setDeathStrategy(new ExplosionDeathStrategy())

                    .build()
    ),
    SHOOTING_EXPLODER(
            gameEngine -> new Enemy.Builder(gameEngine)

                    .setX(30).setY(Util.MARGIN_TOP)
                    .setWidth(32).setHeight(32)
                    .setPointValue(650)

                    .setRenderer(new StillSpriteRenderer(Sprite.SHOOTING_EXPLODER))
                    .setMovementStrategy(new SimpleMovementStrategy(1.3f))
                    .setCollisionStrategy(new HostileMutualCollisionStrategy(Alliance.ENEMY))
                    .setAttackStrategy(new BasicShootingAttackStrategy())
                    .setDeathStrategy(new ExplosionDeathStrategy())

                    .build()
    ),
    ERRATIC_EXPLODER(
            gameEngine -> new Enemy.Builder(gameEngine)

                    .setX(30).setY(Util.MARGIN_TOP)
                    .setWidth(32).setHeight(32)
                    .setPointValue(700)

                    .setRenderer(new StillSpriteRenderer(Sprite.ERRATIC_EXPLODER))
                    .setMovementStrategy(new ErraticMovementStrategy(1.35f))
                    .setAttackStrategy(new BasicShootingAttackStrategy())
                    .setCollisionStrategy(new HostileMutualCollisionStrategy(Alliance.ENEMY))
                    .setDeathStrategy(new ExplosionDeathStrategy())

                    .build()
    ),
    EGG(
            gameEngine -> new Enemy.Builder(gameEngine)

                    .setX(30).setY(Util.MARGIN_TOP)
                    .setWidth(32).setHeight(32)
                    .setPointValue(150)

                    .setRenderer(new StillSpriteRenderer(Sprite.EGG))
                    .setMovementStrategy(new SimpleMovementStrategy(0.64f))
                    .setAttackStrategy(new BasicShootingAttackStrategy())
                    .setCollisionStrategy(new HostileMutualCollisionStrategy(Alliance.ENEMY))
                    .setDeathStrategy(new EggDeathStrategy(5))

                    .build()
    );

    final IEnemyConstructionStrategy constructionStrategy;

    EnemyFactory(IEnemyConstructionStrategy constructionStrategy) {
        this.constructionStrategy = constructionStrategy;
    }

    public Enemy construct(GameEngine gameEngine) {
        return constructionStrategy.construct(gameEngine);
    }

    private interface IEnemyConstructionStrategy {

        Enemy construct(GameEngine gameEngine);

    }

    public static ArrayList<Entity> createBasicEnemyBlock(GameEngine gameEngine) {
        ArrayList<Entity> enemyBlock = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 4; j++)
                enemyBlock.add(
                        new Enemy.Builder(gameEngine)

                                .setX(i*20).setY(j*20 + Util.MARGIN_TOP - 20)
                                .setWidth(16).setHeight(16)
                                .setPointValue(100)

                                .setRenderer(new StillSpriteRenderer(Sprite.BASIC_ENEMY))
                                .setMovementStrategy(
                                        new GroupMovementStrategy(enemyBlock,0.6f)                                )
                                .setAttackStrategy(new NoAttackStrategy())
                                .setCollisionStrategy(
                                        new HostileMutualCollisionStrategy(Alliance.ENEMY))
                                .setDeathStrategy(new SimpleDeathStrategy(SoundClip.POINT))

                                .build()
                );
        }
        return enemyBlock;
    }

    private static class Util {
        public static final int MARGIN_TOP = 50;
    }

}
