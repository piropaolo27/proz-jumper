package com.proz.jumper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jumper extends Game {
	public FileHandle file;
	public SpriteBatch batch;

	public void create() {
		file = Gdx.files.local("save.txt");
		if (!file.exists()) file.writeString("0", false);

		TextureManager.load();
		Display.load();

		batch = new SpriteBatch();
		this.setScreen(new MainScreen(this));
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
		TextureManager.dispose();
		Display.dispose();
		batch.dispose();
	}
}