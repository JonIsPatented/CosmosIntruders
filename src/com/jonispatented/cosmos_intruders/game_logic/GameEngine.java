package com.jonispatented.cosmos_intruders.game_logic;

import com.jonispatented.cosmos_intruders.game_logic.entities.Entity;
import com.jonispatented.cosmos_intruders.game_logic.entities.creatures.enemies.EnemySpawner;
import com.jonispatented.cosmos_intruders.game_logic.entities.creatures.player.Player;
import com.jonispatented.cosmos_intruders.ui.player_input.Input;
import com.jonispatented.cosmos_intruders.ui.sound.SoundClip;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GameEngine implements Runnable {

    public static final int TPS_SET = 200;
    private final int windowWidth = 450, windowHeight = 600;

    private final ConcurrentHashMap<Input, Boolean> playerInputs = new ConcurrentHashMap<>();
    {
        playerInputs.put(Input.LEFT, false);
        playerInputs.put(Input.RIGHT, false);
        playerInputs.put(Input.SHOOT, false);
    }
    private Player player;
    private final List<Entity> entities = new ArrayList<>();
    private final List<Entity> entitiesToRemove = new ArrayList<>();
    private final List<Entity> entitiesToAdd = new ArrayList<>();
    private final List<List<Entity>> enemyBlocks = new ArrayList<>();

    private EnemySpawner spawner;

    private ScoreStateManager scoreStateManager;

    private boolean isRunning = true;
    private boolean gameOver = false;

    public GameEngine() {
        player = new Player(windowWidth/2f - 16, windowHeight - 40, this);
        spawner = new EnemySpawner(this);
        entities.add(player);
        scoreStateManager = new ScoreStateManager(this, player);
        SoundClip.initialize();
    }

    public void gameTick() {

        if (gameOver)
            return;

        entities.addAll(entitiesToAdd);
        entitiesToAdd.clear();

        for (Entity entity : entities) {
            entity.move();
            entity.collide();
            entity.attack();
        }

        entities.removeAll(entitiesToRemove);
        enemyBlocks.forEach(list -> list.removeAll(entitiesToRemove));
        entitiesToRemove.clear();

        spawner.spawnTick();

        scoreStateManager.checkGameOver();

    }

    public ConcurrentHashMap<Input, Boolean> getPlayerInputs() {
        return playerInputs;
    }

    public Player getPlayer() {
        return player;
    }

    public synchronized List<Entity> getEntities() {
        return entities;
    }

    public void markEntityForRemoval(Entity e) {
        entitiesToRemove.add(e);
    }

    public void addEntity(Entity e) {
        entitiesToAdd.add(e);
    }

    public void addEnemyBlock(List<Entity> enemyBlock) {
        enemyBlocks.add(enemyBlock);
        entitiesToAdd.addAll(enemyBlock);
    }

    @Override
    public void run() {
        long now = System.nanoTime();
        long lastTickTime = now;
        double timePerTick = 1E9 / TPS_SET;

        while (isRunning) {
            now = System.nanoTime();
            if (now - lastTickTime >= timePerTick) {
                lastTickTime = now;
                gameTick();
            }
        }
    }

    public void resetGame() {
        gameOver = false;
        player = new Player(windowWidth/2f - 16, windowHeight - 40, this);
        spawner = new EnemySpawner(this);
        scoreStateManager = new ScoreStateManager(this, player);
        entities.clear();
        enemyBlocks.clear();
        entitiesToAdd.clear();
        entitiesToRemove.clear();
        entities.add(player);
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public ScoreStateManager getScoreStateManager() {
        return scoreStateManager;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }
}
