package com.github.sparrow84.jagd.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private SpriteBatch batch;
    private Texture badLogic;

    private Vector2 pos;
    private Vector2 v;

    int deltaX, deltaY;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        badLogic = new Texture("badlogic.jpg");
        pos = new Vector2(0,0);
        v = new Vector2(0.5f,0.5f);

        deltaX = (int) pos.x;
        deltaY = (int) pos.y;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(badLogic, pos.x, pos.y);
        batch.end();

        if (pos.x != deltaX || pos.y != deltaY) {
            pos.add(v);
        }



    }

    @Override
    public void dispose() {
        batch.dispose();
        badLogic.dispose();
        super.dispose();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        deltaX = screenX;
        deltaY = screenY;

        return super.touchDown(screenX, screenY, pointer, button);
    }
}
