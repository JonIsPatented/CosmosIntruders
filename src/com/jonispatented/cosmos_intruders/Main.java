package com.jonispatented.cosmos_intruders;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;
import com.jonispatented.cosmos_intruders.ui.GamePanel;
import com.jonispatented.cosmos_intruders.ui.player_input.PlayerInputManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cosmos Intruders");

        GameEngine gameEngine = new GameEngine();
        Thread gameThread = new Thread(gameEngine);
        gameThread.start();

        GamePanel gamePanel = new GamePanel(gameEngine);
        Thread panelThread = new Thread(gamePanel);
        panelThread.start();

        frame.add(gamePanel);

        frame.setFocusable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.requestFocus();
        frame.addKeyListener(new PlayerInputManager(gameEngine));

        try {
            gameThread.join();
            panelThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.dispose();

    }

}
