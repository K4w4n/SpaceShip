package com.kawan.game;

import com.badlogic.gdx.ApplicationAdapter;

public class SpaceShip extends ApplicationAdapter {
	Screen currentScreen;

	@Override
	public void create() {
		currentScreen = new GameScreen();
	}

	@Override
	public void render() {
		currentScreen.update();
		currentScreen.draw();
	}

	@Override
	public void dispose() {
		currentScreen.dispose();
	}
}
