package com.jonispatented.cosmos_intruders.ui.renderers.score_renderers;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;

import java.awt.*;

public class RunningScoreRenderer implements IScoreRenderer {

    private final GameEngine gameEngine;

    public RunningScoreRenderer(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 22);
        FontMetrics metrics = g.getFontMetrics(font);

        String markerText = String.valueOf(gameEngine.getPlayer().getScore());
        int textSpaceHeight = 20;

        int stringX = (gameEngine.getWindowWidth() - metrics.stringWidth(markerText)) / 2;
        int stringY = textSpaceHeight
                + ((textSpaceHeight - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(markerText, stringX, stringY);
    }

}
