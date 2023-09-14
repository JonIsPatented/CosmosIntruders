package com.jonispatented.cosmos_intruders.ui.player_input;

import com.jonispatented.cosmos_intruders.game_logic.GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInputManager implements KeyListener {

    private final GameEngine gameEngine;

    public PlayerInputManager(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> gameEngine.getPlayerInputs().put(Input.LEFT, true);
            case KeyEvent.VK_D -> gameEngine.getPlayerInputs().put(Input.RIGHT, true);
            case KeyEvent.VK_SPACE -> gameEngine.getPlayerInputs().put(Input.SHOOT, true);
            case KeyEvent.VK_ESCAPE -> gameEngine.setRunning(false);
            case KeyEvent.VK_R -> gameEngine.resetGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> gameEngine.getPlayerInputs().put(Input.LEFT, false);
            case KeyEvent.VK_D -> gameEngine.getPlayerInputs().put(Input.RIGHT, false);
            case KeyEvent.VK_SPACE -> gameEngine.getPlayerInputs().put(Input.SHOOT, false);
        }
    }

}
