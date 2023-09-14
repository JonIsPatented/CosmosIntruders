package com.jonispatented.cosmos_intruders.ui.renderers.sprites;

import java.awt.image.BufferedImage;

public enum Sprite {

    BASIC_ENEMY(SpriteSheet.getSprite(3, 0, 8)),
    BASIC_EXPLODER(SpriteSheet.getSprite(3, 1, 16)),
    BASIC_SHOOTER(SpriteSheet.getSprite(2, 0, 16)),
    ERRATIC_SHOOTER(SpriteSheet.getSprite(4, 1, 16)),
    ERRATIC_EXPLODER(SpriteSheet.getSprite(2, 1, 16)),
    SHOOTING_EXPLODER(SpriteSheet.getSprite(1, 1, 16)),
    EGG(SpriteSheet.getSprite(0, 1, 16)),
    PLAYER(SpriteSheet.getSprite(0,0, 16)),
    PLAYER_BULLET(SpriteSheet.getSprite(1, 0, 6)),
    ENEMY_BULLET(SpriteSheet.getSprite(4, 0, 6));

    private final BufferedImage sprite;

    Sprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage sprite() {
        return sprite;
    }

}
