package com.jonispatented.cosmos_intruders.game_logic.entities.creatures.enemies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;

import java.util.Random;

public class EnemySpawner {

    private final GameEngine gameEngine;
    private final Random rand;

    private int spawnCooldown;

    public EnemySpawner(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        rand = new Random();
        spawnCooldown = 0;
    }

    public void spawnTick() {

        if (gameEngine.getEntities().stream().noneMatch(e -> e instanceof Enemy))
            spawnCooldown = (int) Math.min(GameEngine.TPS_SET / 2f, spawnCooldown);

        if (spawnCooldown > 0) {
            spawnCooldown--;
            return;
        }

        switch (rand.nextInt(10)) {
            case 0, 1, 2 -> {
                gameEngine.addEnemyBlock(EnemyFactory.createBasicEnemyBlock(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(8,14);
            }
            case 3, 4 -> {
                gameEngine.addEntity(EnemyFactory.BASIC_SHOOTER.construct(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(2,8);
            }
            case 5 -> {
                gameEngine.addEntity(EnemyFactory.ERRATIC_SHOOTER.construct(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(3,10);
            }
            case 6 -> {
                gameEngine.addEntity(EnemyFactory.BASIC_EXPLODER.construct(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(4,11);
            }
            case 7 -> {
                gameEngine.addEntity(EnemyFactory.ERRATIC_EXPLODER.construct(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(3,12);
            }
            case 8 -> {
                gameEngine.addEntity(EnemyFactory.EGG.construct(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(6,11);
            }
            case 9 -> {
                gameEngine.addEntity(EnemyFactory.SHOOTING_EXPLODER.construct(gameEngine));
                spawnCooldown = GameEngine.TPS_SET * rand.nextInt(5,9);
            }
        }
    }

}
