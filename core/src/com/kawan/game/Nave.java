package com.kawan.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Nave implements Entity {
    private Texture texture = new Texture("spaceship.png");
    private Sprite sprit = new Sprite(texture);
    private float x = 0, y = 0;
    private final float velocity = 10;
    private int countDelayMissile = 0;
    ArrayList<Missile> missiles = new ArrayList<Missile>();

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
        if (countDelayMissile > 0) {
            countDelayMissile--;
        }

        ArrayList<Missile> newMissiles = new ArrayList<Missile>();
        for (Missile missile : missiles) {
            if (missile.getX() < Gdx.graphics.getWidth())
                newMissiles.add(missile);
        }
        missiles = newMissiles;
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
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && countDelayMissile == 0) {
            missiles.add(new Missile(x, y + sprit.getHeight() / 2));
            countDelayMissile = 10;
        }
    }

    public ArrayList<Missile> getMissiles() {
        return missiles;
    }

    public void dispose() {
        texture.dispose();
    }
}
