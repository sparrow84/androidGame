package com.github.sparrow84.jagd.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.sparrow84.jagd.Star2DGame;
import com.github.sparrow84.jagd.StarGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new LwjglApplication(new StarGame(), config);
		float aspect = 3f / 4f;
		config.height = 500;
		config.width = (int) (config.height * aspect);
		config.resizable = false;
		new LwjglApplication(new Star2DGame(), config);
	}
}
