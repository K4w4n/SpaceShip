package com.kawan.game;

public class GameScreen extends Screen {
    private Game game;

    GameScreen() {
        GameConfig config = new GameConfig(1);
        game = new Game(config);
    }

    @Override
    public void draw() {
        game.draw();
        super.draw();
    }

    @Override
    public void update() {
        game.update();
        super.update();
    }

    @Override
    public void dispose() {
        game.dispose();
        super.dispose();
    }
}
