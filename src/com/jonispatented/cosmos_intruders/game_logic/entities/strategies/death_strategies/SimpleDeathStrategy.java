package com.jonispatented.cosmos_intruders.game_logic.entities.strategies.death_strategies;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

public class SimpleDeathStrategy implements IDeathStrategy {

    private final SoundClip soundClip;

    public SimpleDeathStrategy(SoundClip soundClip) {
        this.soundClip = soundClip;
    }

    @Override
    public void die(Entity self, GameEngine gameEngine) {
        gameEngine.markEntityForRemoval(self);
        if (soundClip != null)
            soundClip.play();
    }
}
