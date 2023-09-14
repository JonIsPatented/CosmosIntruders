package com.jonispatented.cosmos_intruders.game_logic;

public enum Direction {

    UP (0,-1),
    DOWN (0,1),
    LEFT (-1,0),
    RIGHT (1,0),

    UP_LEFT (-0.707106f,-0.707106f),
    UP_RIGHT (0.707106f,-0.707106f),
    DOWN_LEFT (-0.707106f,0.707106f),
    DOWN_RIGHT (0.707106f,0.707106f);

    Direction(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private final float x, y;

    public float x() { return x; }
    public float y() { return y; }

}
