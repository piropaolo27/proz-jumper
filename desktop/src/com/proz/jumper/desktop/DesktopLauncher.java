package com.proz.jumper.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.proz.jumper.Jumper;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Jumpitsu";
		config.width = 720;
		config.height = 1280;
		new LwjglApplication(new Jumper(), config);
	}
}
