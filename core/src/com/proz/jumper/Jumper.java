package com.proz.jumper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Class that is used manage other classes, load assets, operate on files.
 */
public class Jumper extends Game {
	/**
	 * FileHandle used to store highscores
	 */
	public FileHandle file;

	/**
	 * SpriteBatch defined for the whole programme. It is kind of a buffer where all the images
	 * that are to be displayed in a current frame are put beforehand.
	 */
	public SpriteBatch batch;

	/**
	 * In this case the file is loaded, variables are initialised, and MainScreen is set. It is somehow
	 * similar to a class constructor.
	 */
	public void create() {
		file = Gdx.files.local("save.txt");
		if (!file.exists()) file.writeString("0", false);

		TextureManager.load();
		Display.load();
		SoundManager.load();

		batch = new SpriteBatch();
		this.setScreen(new MainScreen(this));
	}

	/**
	 * Rendering of a current screen.
	 */
	public void render() {
		super.render(); //important!
	}

	/**
	 * This method is used to remove all the unused things.
	 */
	public void dispose() {
		TextureManager.dispose();
		Display.dispose();
		SoundManager.dispose();
		batch.dispose();
	}
}