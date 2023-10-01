package com.kawan.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceShip extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, tNave;
	private Nave nave;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("bg.png");
		nave = new Nave();
	}

	@Override
	public void render() {
		nave.move();
		ScreenUtils.clear(1, 0, 0, 1);
		
		batch.begin();
		batch.draw(img, 0, 0);

		ArrayList<Missile> missiles = nave.getMissiles();
		for (Missile missile : missiles) {
			missile.move();
			batch.draw(missile.getSprite(), missile.getX(), missile.getY());
		}
		batch.draw(nave.getSprite(), nave.getX(), nave.getY());
		System.out.println(missiles.size());
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		nave.dispose();
	}
}
