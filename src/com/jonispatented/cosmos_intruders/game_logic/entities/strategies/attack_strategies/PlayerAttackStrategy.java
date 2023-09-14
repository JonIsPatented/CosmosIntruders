package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Alliance;
import com.jonispatented.cosmos_intruders.game_logic.entities.Bullet;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.ui.player_input.Input;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.StillSpriteRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

public class PlayerAttackStrategy implements IAttackStrategy {

    int fireCooldown = 0;

    @Override
    public void attack(Entity player, GameEngine gameEngine) {

        if (gameEngine.getEntities().stream()
                .noneMatch(e -> e instanceof Bullet && e.getAlliance() == Alliance.PLAYER ))
            fireCooldown = 0;

        if (fireCooldown > 0) {
            fireCooldown--;
            return;
        }

        if (!gameEngine.getPlayerInputs().get(Input.SHOOT))
            return;

        Bullet bullet = new Bullet(
                player.getX() + player.getWidth()/2 + 0.5f - Bullet.WIDTH / 2f,
                player.getY(),
                Direction.UP,
                6.1f,
                gameEngine,
                new StillSpriteRenderer(Sprite.PLAYER_BULLET),
                Alliance.PLAYER
        );
        bullet.setHeight(10);

        gameEngine.addEntity(bullet);

        SoundClip.SHOOT.play();

        fireCooldown = GameEngine.TPS_SET / 2;
    }

}
