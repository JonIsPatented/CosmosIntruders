package com.jonispatented.cosmos_intruders.ui.renderers.sprites;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

    private static final int GRID_SIZE = 16;
    private static BufferedImage spriteSheet;

    static {
        try {
            spriteSheet = ImageIO.read(
                    new File("assets/sprite_sheet.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getSprite(int x, int y, int spriteSize) {
        Image tempImage = spriteSheet.getSubimage(x * GRID_SIZE, y * GRID_SIZE, spriteSize, spriteSize);
        tempImage = tempImage.getScaledInstance(2 * spriteSize, 2 * spriteSize, Image.SCALE_DEFAULT);
        BufferedImage sprite = new BufferedImage(2 * spriteSize, 2 * spriteSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = sprite.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();
        return sprite;
    }

}
