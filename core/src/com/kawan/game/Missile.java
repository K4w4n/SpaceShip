package com.kawan.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Missile implements Entity {
    private SpriteBatch batch;
    private Texture texture = new Texture("missile.png");
    private Sprite sprit = new Sprite(texture);
    private float x = 0, y = 0;
    private final float velocity = 30;
    private boolean destroyed = false;

    Missile(float x, float y) {
        this.x = x;
        this.y = y - sprit.getHeight() / 2;
    }

    @Override
    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    float getWidth() {
        return texture.getWidth();
    }

    float getHeight() {
        return texture.getHeight();
    }

    void destroy() {
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void update() {
        x += velocity;
    }

    public void draw() {
        if (!destroyed)
            batch.draw(sprit, x, y);
    }

    public void dispose() {
        texture.dispose();
    }
}