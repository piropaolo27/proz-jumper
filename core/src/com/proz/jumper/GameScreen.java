package com.proz.jumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Most important class in the whole project. It serves purpose of managing
 * all the things connected with the actual gameplay.
 * Created by volterra on 28.04.17.
 */
public class GameScreen implements Screen {
    /**
     * Game that is to be used in this screen.
     */
    final Jumper game;

    /**
     * World that holds the information about the objects' positions etc.
     */
    private GameWorld world;
    /**
     * Custom inputProcessor handling input of an user.
     */
    private InputHandler inputProcessor;

    /**
     * GameScren constructor that gets a Game instance when initialised.
     * @param game  Jumper game that is to be processed in this Gamescreen
     */
    public GameScreen (final Jumper game) {
        this.game = game;
        world = new GameWorld();

        inputProcessor = new InputHandler(world.getPlayer());
        Gdx.input.setInputProcessor(inputProcessor);
    }

    /**
     * This is the main method of the GameScreen class. It is called with every shown frame.
     * In this portion of the code are considered all the methods connected with displaying GameObjects,
     * as well as processing collisions and moving the camera.
     * @param delta   time between two frames
     */
    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.getCamera().move();
        world.getCamera().update();
        game.batch.setProjectionMatrix(world.getCamera().combined);
        world.generateMorePlatforms();
        world.platformsUpdate();
        world.platformsCollision();

        game.batch.begin();
        Display.displayBackground(world.getCamera(), game.batch);
        Display.displayPlatforms(world.getPlatforms(), game.batch);
        Display.displayPlayer(world.getPlayer(), game.batch);
        Display.displayGameScreenTexts(this.world, game.batch);
        game.batch.end();

        world.getPlayer().updateMotion();
        //this part checks if the player is alive, if not we go to the ScoreScreen
        //if in this game, player managed to beat current highest score, it is written to a file
        if (!world.isPlayerAlive()){
            Integer temp = Integer.valueOf(game.file.readString());
            if (world.getScore() > temp)    game.file.writeString(Integer.toString(world.getScore()), false);
            game.setScreen(new ScoreScreen(game));
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
