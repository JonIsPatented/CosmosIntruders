package com.jonispatented.cosmos_intruders.ui;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    public static final int FPS_SET = 120;

    private final GameEngine gameEngine;

    public GamePanel(GameEngine gameEngine) {
        this.gameEngine = gameEngine;

        setPreferredSize(new Dimension(gameEngine.getWindowWidth(), gameEngine.getWindowHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.BLACK);
        for (Entity e : new ArrayList<>(gameEngine.getEntities())) {
            e.render(g);
        }

        gameEngine.getScoreStateManager().drawScoreDisplay(g);
    }

    @Override
    public void run() {
        long now = System.nanoTime();
        long lastTickTime = now;
        double timePerTick = 1E9 / FPS_SET;

        while (gameEngine.isRunning()) {
            now = System.nanoTime();
            if (now - lastTickTime >= timePerTick) {
                lastTickTime = now;
                repaint();
            }
        }
    }
}
