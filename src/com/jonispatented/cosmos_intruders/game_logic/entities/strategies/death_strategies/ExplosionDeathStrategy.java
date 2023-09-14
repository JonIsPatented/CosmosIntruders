package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies;

import com.jonispatented.cosmos_intruders.game_logic.Direction;
import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Bullet;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.StillSpriteRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

public class ExplosionDeathStrategy implements IDeathStrategy {

    @Override
    public void die(Entity self, GameEngine gameEngine) {

        float xOrigin = self.getX() + self.getWidth() / 2;
        float yOrigin = self.getY() + self.getHeight() / 2;

        for (Direction dir : Direction.values()) {
            gameEngine.addEntity(
                    new Bullet(xOrigin, yOrigin, dir, 2.8f,
                            gameEngine, new StillSpriteRenderer(Sprite.ENEMY_BULLET), self.getAlliance())
            );
        }

        gameEngine.markEntityForRemoval(self);

        SoundClip.EXPLODE.play();

    }

}
