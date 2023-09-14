package com.jonispatented.cosmos_intruders.ui.renderers.score_renderers;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;

import java.awt.*;

public class GameOverScoreRenderer implements IScoreRenderer {

    private GameEngine gameEngine;

    public GameOverScoreRenderer(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 36);
        FontMetrics metrics = g.getFontMetrics(font);

        String markerText = "FINAL SCORE:";
        String scoreText = String.valueOf(gameEngine.getPlayer().getScore());

        int markerX = (gameEngine.getWindowWidth() - metrics.stringWidth(markerText)) / 2;
        int markerY = (int) (((gameEngine.getWindowHeight() - 2.5f * metrics.getHeight()) / 2) + metrics.getAscent());
        g.setFont(font);
        g.drawString(markerText, markerX, markerY);

        int stringX = (gameEngine.getWindowWidth() - metrics.stringWidth(scoreText)) / 2;
        int stringY = (int) (((gameEngine.getWindowHeight() + 0.5f * metrics.getHeight()) / 2) + metrics.getAscent());
        g.setFont(font);
        g.drawString(scoreText, stringX, stringY);
    }

}
