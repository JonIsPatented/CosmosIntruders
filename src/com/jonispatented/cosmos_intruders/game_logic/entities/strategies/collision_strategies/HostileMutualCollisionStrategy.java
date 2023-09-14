package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Alliance;
import com.jonispatented.cosmos_intruders.game_logic.entities.Bullet;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.game_logic.entities.creatures.enemies.Enemy;

import java.util.List;

public class HostileMutualCollisionStrategy implements ICollisionStrategy {

    Alliance alliance;

    public HostileMutualCollisionStrategy(Alliance alliance) {
        this.alliance = alliance;
    }

    @Override
    public void collide(Entity self, GameEngine gameEngine) {
        List<Entity> enemies = gameEngine.getEntities().stream()
                .filter(e -> e.getAlliance() != alliance && !(e instanceof Bullet)).toList();
        for (Entity target : enemies) {
            if (((self.getX() > target.getX() && self.getX() < target.getX() + target.getWidth())// These 3 lines check
                    || (self.getX() + self.getWidth() > target.getX()                            // whether l/r sides
                    && self.getX() + self.getWidth() < target.getX() + target.getWidth()))       // are between target

                    &&

                    ((self.getY() > target.getY() && self.getY() < target.getY() + target.getHeight()   // These here check
                            || (self.getY() + self.getHeight() > target.getY()                          // if l/r sides are
                            && self.getY() + self.getHeight() < target.getY() + target.getHeight()))))  // between up/down
            {
                hitTarget(self, target, gameEngine);
                return;
            }
        }
    }

    private void hitTarget(Entity self, Entity target, GameEngine gameEngine) {
        self.die();
        target.die();
        if (alliance == Alliance.PLAYER && target instanceof Enemy) {
            gameEngine.getPlayer().adjScore(((Enemy)target).getPointValue());
        }
    }
}
