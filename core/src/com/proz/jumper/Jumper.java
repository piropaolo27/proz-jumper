package com.proz.jumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jumper extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private GameWorld world;
	private InputHandler inputProcessor;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 600, 900);
		TextureManager.load();
		world = new GameWorld();
		inputProcessor = new InputHandler(world.getPlayer());
		Gdx.input.setInputProcessor(inputProcessor);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		Display.displayPlatform(world.platform1, batch);
		Display.displayPlatform(world.platform2, batch);
		Display.displayPlayer(world.getPlayer(), batch);
		batch.end();

		world.getPlayer().updateMotion();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
