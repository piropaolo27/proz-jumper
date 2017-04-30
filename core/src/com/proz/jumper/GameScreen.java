package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by volterra on 28.04.17.
 */

public class GameScreen implements Screen {
    final Jumper game;

    private GameWorld world;
    private InputHandler inputProcessor;

    public GameScreen (final Jumper game) {
        this.game = game;
        world = new GameWorld();

        inputProcessor = new InputHandler(world.getPlayer());
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.getCamera().move();
        world.getCamera().update();
        game.batch.setProjectionMatrix(world.getCamera().combined);
        world.generateMorePlatforms();
        world.platformsCollision();

        game.batch.begin();
        Display.displayBackground(world.getCamera(), game.batch);
        Display.displayPlatforms(world.getPlatforms(), game.batch);
        Display.displayPlayer(world.getPlayer(), game.batch);
        game.font.draw(game.batch, Integer.toString(world.getScore()), world.getCamera().viewportWidth * 0.07f,
                world.getCamera().viewportHeight * 0.45f + world.getCamera().position.y);
        game.batch.end();

        world.getPlayer().updateMotion();
        if (!world.isPlayerAlive()){
            Integer temp = Integer.valueOf(game.file.readString());
            if (world.getScore() > temp)    game.file.writeString(Integer.toString(world.getScore()), false);
            game.setScreen(new ScoreScreen(game));
            dispose();
        }
    }

    @Override
    public void dispose () {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
