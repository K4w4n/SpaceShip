package com.kawan.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

interface Entity {
    public Sprite getSprite();

    public float getX();

    public float getY();

    public void move();

    public void dispose();
}
