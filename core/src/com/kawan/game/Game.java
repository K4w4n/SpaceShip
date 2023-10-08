package com.kawan.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game {
    SpriteBatch batch;
    Texture img, tNave;
    private Nave nave;
    private ArrayList<Enemy> enemyList;

    Game(GameConfig config) {
		batch = new SpriteBatch();
		img = new Texture("bg.png");
		nave = new Nave();
		nave.setBatch(batch);
		enemyList = config.getEnemyList();
        for (Enemy enemy : enemyList) {
            enemy.setBatch(batch);
        }
    }

    public void update() {
		for (Enemy enemy : enemyList) {
			enemy.update();
		}
		nave.update();
		blowUpEnemies();
		removeDestroyedEnemies();
	}

    
	private void blowUpEnemies() {
		ArrayList<Missile> missileList = nave.getMissiles();
		for (Enemy enemy : enemyList) {
			float enemyX = enemy.getX();
			float enemyY = enemy.getY();
			float enemyWidth = enemy.getWidth();
			float enemyHeight = enemy.getHeight();
			for (Missile missile : missileList) {
				float missileX = missile.getX();
				float missileY = missile.getY();
				float missileWidth = missile.getWidth();
				float missileHeight = missile.getHeight();

				if ((missileX + missileWidth >= enemyX) &&
						(missileX <= enemyX + enemyWidth) &&
						(missileY + missileHeight >= enemyY) &&
						(missileY <= enemyY + enemyHeight)) {
					missile.destroy();
					enemy.destroy();
				}
			}
		}
	}

	private void removeDestroyedEnemies() {
		ArrayList<Enemy> newEnemyList = new ArrayList<Enemy>();
		for (Enemy enemy : enemyList) {
			if (!enemy.isDestroyed()) {
				newEnemyList.add(enemy);
			}
		}
		enemyList = newEnemyList;
	}

    public void draw() {
		batch.begin();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.draw(img, 0, 0);
		for (Enemy enemy : enemyList) {
			enemy.draw();
		}
		nave.draw();
		batch.end();
	}

	public void dispose() {
		batch.dispose();
		img.dispose();
		nave.dispose();
	}
}
