package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Classed displayed after player loses the game; contains information about the highest score
 * ever achieved. Touching the screen or pressing space key restarts the game.
 * Created by volterra on 28.04.17.
 */

public class ScoreScreen implements Screen {
    /**
     * Game passed onto the ScoreScreen.
     */
    final Jumper game;

    /**
     * Camera used to show all the things in this screen.
     */
    OrthographicCamera camera;

    /**
     * Constructor that gets a Jumper game instance.
     * @param game  reference to a game that is to be processed
     */
    public ScoreScreen(final Jumper game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 1280);
    }

    /**
     * This is the main method of the ScoreScreen class. It is called with every shown frame.
     * In this portion of the code are considered all the methods connected with displaying scores, texts.
     * @param delta   time between two frames
     */
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        Display.displayBackground(camera, game.batch);
        Display.displayScoreScreenTexts(game.file, camera, game.batch);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            if(Gdx.input.getX() < 300 && Gdx.input.getY() < 300){
                game.setScreen(new CreditsScreen(game));
                dispose();
            }
            else {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        }
    }

    //Those methods are compulsory as Screen is an interface.
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
