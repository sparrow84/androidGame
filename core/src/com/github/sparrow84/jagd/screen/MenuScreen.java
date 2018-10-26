package com.github.sparrow84.jagd.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private Texture badLogic;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;
    private Vector2 buf;
    float speed;

    @Override
    public void show() {
        super.show();
        badLogic = new Texture("badlogic.jpg");
        pos = new Vector2(0, 0);
        v = new Vector2(0.05f, 0.05f);
        touch = new Vector2();
        buf = new Vector2();

        speed = 0.1f;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 1, 15, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        buf.set(touch);
        if (buf.sub(pos).len() > v.len()) {
            pos.add(v);
        } else {
            pos.set(touch);
        }

        batch.begin();
        batch.draw(badLogic, pos.x, pos.y, 0.5f, 0.5f);
        batch.end();

    }

    @Override
    public void dispose() {
        badLogic.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        v.set(touch.cpy().sub(pos).scl(speed));
        return false;
    }
}