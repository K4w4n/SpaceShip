package com.kawan.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

interface Entity {

    public void update();

    public void draw();

    public void dispose();

    public void setBatch(SpriteBatch batch);
}
