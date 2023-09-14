package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Alliance;
import com.jonispatented.cosmos_intruders.game_logic.entities.Bullet;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.StillSpriteRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

import java.util.Random;

public class BasicShootingAttackStrategy implements IAttackStrategy {

    private final Random rand;

    public BasicShootingAttackStrategy() {
        rand = new Random();
    }

    @Override
    public void attack(Entity e, GameEngine gameEngine) {
        if (rand.nextInt(GameEngine.TPS_SET) == 0) {
            gameEngine.addEntity(
                    new Bullet(
                            e.getX() + e.getWidth()/2 + 0.5f - Bullet.WIDTH / 2f,
                            e.getY() + e.getHeight() - Bullet.HEIGHT,
                            Direction.DOWN,
                            2.4f,
                            gameEngine,
                            new StillSpriteRenderer(Sprite.ENEMY_BULLET),
                            Alliance.ENEMY
                    )
            );
            SoundClip.SHOOT.play();
        }
    }

}
