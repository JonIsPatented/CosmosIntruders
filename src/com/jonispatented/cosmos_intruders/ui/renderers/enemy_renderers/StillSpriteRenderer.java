package com.jonispatented.cosmos_intruders.ui.renderers.enemy_renderers;

import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.ui.renderers.sprites.Sprite;

import java.awt.*;

public class StillSpriteRenderer implements IEntityRenderer {

    private Sprite sprite;

    public StillSpriteRenderer(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void render(Entity e, Graphics g) {
        g.drawImage(sprite.sprite(), (int) e.getX(), (int) e.getY(), null);
    }

}
