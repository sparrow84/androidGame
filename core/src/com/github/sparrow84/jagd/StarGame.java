package com.github.sparrow84.jagd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture badLogic;
	Texture funnyCat;
	TextureRegion region;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		badLogic = new Texture("badlogic.jpg");
		funnyCat = new Texture("qwe.png");
		region = new TextureRegion(badLogic, 144, 20, 50, 30);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(funnyCat, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		batch.draw(funnyCat, 0, 0, 200, 200);
//		batch.setColor(1, 0, 0, 1);
//		batch.draw(badLogic, 100, 100);
//		batch.setColor(0, 1, 0, 1);
//		batch.draw(region, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		badLogic.dispose();
	}
}
