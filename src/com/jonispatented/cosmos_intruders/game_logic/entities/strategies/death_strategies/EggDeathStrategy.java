package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.game_logic.entities.creatures.enemies.EnemyFactory;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

import java.util.Random;

public class EggDeathStrategy implements IDeathStrategy {

    private int hp;

    public EggDeathStrategy(int hp) {
        this.hp = hp;
    }

    @Override
    public void die(Entity self, GameEngine gameEngine) {

        if (hp > 1) {
            hp--;
            SoundClip.POINT.play();
            return;
        }

        gameEngine.markEntityForRemoval(self);

        EnemyFactory[] enemies = {
                EnemyFactory.BASIC_SHOOTER,
                EnemyFactory.ERRATIC_SHOOTER,
                EnemyFactory.BASIC_EXPLODER,
                EnemyFactory.SHOOTING_EXPLODER
        };
        Random rand = new Random();
        Entity spawn = enemies[rand.nextInt(enemies.length)].construct(gameEngine);

        spawn.setX(self.getX() + self.getWidth() / 2 - spawn.getWidth() / 2);
        spawn.setY(self.getY() + self.getHeight() / 2 - spawn.getHeight() / 2);
        gameEngine.addEntity(spawn);

        SoundClip.EXPLODE.play();

    }

}
