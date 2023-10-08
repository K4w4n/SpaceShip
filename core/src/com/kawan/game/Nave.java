package com.kawan.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nave implements Entity {
    private SpriteBatch batch;
    private Texture texture = new Texture("spaceship.png");
    private Sprite sprit = new Sprite(texture);
    private float x = 0, y = 0;
    private final float velocity = 10;
    private int countDelayMissile = 0;
    private ArrayList<Missile> missiles = new ArrayList<Missile>();

    @Override
    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
        for (Missile missile : missiles) {
            missile.setBatch(batch);
        }
    }

    public ArrayList<Missile> getMissiles() {
        return missiles;
    }

    public void update() {
        move();
        clearMissiles();
        fireMissile();
        updateMissiles();
    }

    private void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && (x + velocity + sprit.getWidth()) <= Gdx.graphics.getWidth()) {
            x += velocity;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && x - velocity >= 0) {
            x -= velocity;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && y + sprit.getHeight() + velocity <= Gdx.graphics.getHeight()) {
            y += velocity;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && y - velocity >= 0) {
            y -= velocity;
        }
    }

    private void clearMissiles() {
        if (countDelayMissile > 0) {
            countDelayMissile--;
        }

        ArrayList<Missile> newMissiles = new ArrayList<Missile>();
        for (Missile missile : missiles) {
            if (missile.getX() < Gdx.graphics.getWidth() && !missile.isDestroyed())
                newMissiles.add(missile);
        }
        missiles = newMissiles;
    }

    private void fireMissile() {
        boolean spacePressed = Gdx.input.isKeyPressed(Input.Keys.SPACE);
        boolean reloadedMissiles = countDelayMissile == 0;
        boolean fireMissile = spacePressed && reloadedMissiles;
        if (fireMissile) {
            Missile missile = new Missile(x, y + sprit.getHeight() / 2);
            missile.setBatch(batch);
            missiles.add(missile);
            countDelayMissile = 10;
        }
    }

    private void updateMissiles() {
        for (Missile missile : missiles) {
            missile.update();
        }
    }

    public void draw() {
        for (Missile missile : missiles) {
            missile.draw();
        }
        batch.draw(sprit, x, y);
    }

    public void dispose() {
        texture.dispose();
    }
}