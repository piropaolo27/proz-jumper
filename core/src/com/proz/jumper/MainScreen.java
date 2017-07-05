package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Class that is displayed at the very beginning, before starting the game. Touching the screen or
 * pressing space key starts the game.
 * Created by volterra on 28.04.17.
 */

public class MainScreen implements Screen {
    /**
     * Game pased onto the MainScreen.
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
    public MainScreen(final Jumper game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 1280);
    }

    /**
     * This is the main method of the MainScreen class. It is called with every shown frame.
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
        Display.displayMainBackground(camera, game.batch);
        //Display.displayMainScreenTexts(camera, game.batch);
        game.batch.end();

        if (Gdx.input.justTouched() && Gdx.input.getX() > Gdx.graphics.getWidth() * 7/18f && Gdx.input.getX() < Gdx.graphics.getWidth() * 11/18f
                && Gdx.input.getY() > Gdx.graphics.getHeight() * 29/64f && Gdx.input.getY() < Gdx.graphics.getHeight() * 37/64f) {
            game.setScreen(new GameScreen(game));
            dispose();
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
