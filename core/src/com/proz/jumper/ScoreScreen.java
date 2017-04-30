package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by volterra on 28.04.17.
 */

public class ScoreScreen implements Screen {
    final Jumper game;
    OrthographicCamera camera;

    public ScoreScreen(final Jumper game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 1280);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        Display.displayBackground(camera, game.batch);
        game.fontL.draw(game.batch, "HIGH SCORE", camera.viewportWidth * 0.05f, camera.viewportHeight * 0.5f);
        game.fontL.draw(game.batch, game.file.readString(), camera.viewportWidth * 0.33f, camera.viewportHeight * 0.1f);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
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
