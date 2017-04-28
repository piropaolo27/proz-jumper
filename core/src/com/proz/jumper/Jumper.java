package com.proz.jumper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Jumper extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public FreeTypeFontGenerator generator;
	public FreeTypeFontGenerator.FreeTypeFontParameter parameter;

	public void create() {
		TextureManager.load();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("manaspc.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = 50;
		batch = new SpriteBatch();
		//Use LibGDX's default Arial font.
		font = generator.generateFont(parameter);
		this.setScreen(new MainScreen(this));
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
		TextureManager.dispose();
		generator.dispose();
		batch.dispose();
		font.dispose();
	}
}