package com.kawan.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Missile implements Entity {
    private Texture texture = new Texture("missile.png");
    private Sprite sprit = new Sprite(texture);
    private float x = 0, y = 0;
    private final float velocity = 30;

    Missile(float x, float y) {
        this.x = x;
        this.y = y - sprit.getHeight() / 2;
    }

    public Sprite getSprite() {
        return sprit;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move() {
        x += velocity;
    }

    public void dispose() {
        texture.dispose();
    }
}
