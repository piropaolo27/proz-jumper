package com.proz.jumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jumper extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameCamera camera;
	private GameWorld world;
	private InputHandler inputProcessor;

	@Override
	public void create () {
		TextureManager.load();
		batch = new SpriteBatch();
		world = new GameWorld();
		camera = new GameCamera(world.getPlayer());
		camera.setToOrtho(false, 720, 1280);
		inputProcessor = new InputHandler(world.getPlayer());
		Gdx.input.setInputProcessor(inputProcessor);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.move();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		world.platformsCollision();

		batch.begin();
		Display.displayBackground(camera, batch);
		Display.displayPlatforms(world.getPlatforms(), batch);
		Display.displayPlayer(world.getPlayer(), batch);
		batch.end();

		world.getPlayer().updateMotion();

	}

	@Override
	public void dispose () {
		batch.dispose();
		TextureManager.dispose();
	}
}