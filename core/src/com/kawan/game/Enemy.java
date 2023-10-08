package com.kawan.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy implements Entity {
    private SpriteBatch batch;
    private Texture texture = new Texture("enemy.png");
    private Sprite sprit = new Sprite(texture);
    private float x = 0, y = 0;
    private boolean destroyed = false;

    Enemy(int i, int j, SpriteBatch batch) {
        this.x = Gdx.graphics.getWidth() + i * (texture.getWidth() + 50);
        this.y = j * (texture.getHeight() + 50);
        this.batch = batch;
    }
    
    Enemy(int i, int j, int type) {
        this.x = Gdx.graphics.getWidth() + i * (texture.getWidth() + 50);
        this.y = j * (texture.getHeight() + 50);
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

    public float getHeight() {
        return texture.getHeight();
    }

    public float getWidth() {
        return texture.getWidth();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    void destroy() {
        destroyed = true;
    }

    @Override
    public void update() {
        x -= 5;
    }

    @Override
    public void draw() {
        if (!destroyed)
            batch.draw(sprit, x, y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

}
