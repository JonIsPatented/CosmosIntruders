package com.jonispatented.cosmos_intruders.game_logic.entities.creatures.player;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Alliance;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.attack_strategies.PlayerAttackStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.collision_strategies.NoCollisionStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies.SimpleDeathStrategy;
import com.jonispatented.cosmos_intruders.game_logic.entities.strategies.movement_strategies.PlayerMovementStrategy;
import com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers.StillSpriteRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

public class Player extends Entity {

    private int score;

    public Player(float x, float y, GameEngine gameEngine) {
        super(x, y, 32, 32, gameEngine, new StillSpriteRenderer(Sprite.PLAYER),
                new PlayerMovementStrategy(0.8f), new PlayerAttackStrategy(),
                new SimpleDeathStrategy(SoundClip.EXPLODE), new NoCollisionStrategy(), Alliance.PLAYER);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void adjScore(int amt) {
        score += amt;
    }
}
