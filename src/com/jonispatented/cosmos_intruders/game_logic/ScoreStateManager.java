package com.jonispatented.cosmos_intruders.game_logic;

import com.jonispatented.cosmos_intruders.game_logic.entities.Bullet;
import com.jonispatented.cosmos_intruders.game_logic.entities.creatures.player.Player;
import com.jonispatented.cosmos_intruders.ui.renderers.score_renderers.GameOverScoreRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.score_renderers.IScoreRenderer;
import com.jonispatented.cosmos_intruders.ui.renderers.score_renderers.RunningScoreRenderer;

import java.awt.*;

public class ScoreStateManager {

    private final GameEngine gameEngine;
    private final Player player;
    private IScoreRenderer scoreRenderer;

    public ScoreStateManager(GameEngine gameEngine, Player player) {
        this.gameEngine = gameEngine;
        this.player = player;
        this.scoreRenderer = new RunningScoreRenderer(gameEngine);
    }

    public void checkGameOver() {
        if (!gameEngine.getEntities().contains(player)
                || gameEngine.getEntities().stream()
                .anyMatch(e -> !(e instanceof Bullet) && e.getY() > gameEngine.getWindowHeight() - e.getHeight())) {
            gameEngine.setGameOver(true);
            scoreRenderer = new GameOverScoreRenderer(gameEngine);
        }
    }

    public void drawScoreDisplay(Graphics g) {
        scoreRenderer.draw(g);
    }

}
