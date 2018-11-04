package com.github.sparrow84.jagd.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Base2DScreen;
import com.github.sparrow84.jagd.math.Rect;
import com.github.sparrow84.jagd.sprite.Background;
import com.github.sparrow84.jagd.sprite.BtExit;
import com.github.sparrow84.jagd.sprite.BtPlay;
import com.github.sparrow84.jagd.sprite.Star;

public class MenuScreen extends Base2DScreen {

    private static final int STAR_COUNT = 256;

    private Texture bgTexture;
    private Background background;

    private TextureAtlas textureAtlas;
    private Star[] stars;

    private Star star;
    private BtExit btExit;
    private BtPlay btPlay;

    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("bg.png");
        background = new Background(new TextureRegion(bgTexture));
        textureAtlas = new TextureAtlas("menuAtlas.tpack");

        btExit = new BtExit(textureAtlas);
        btPlay = new BtPlay(textureAtlas);

        star = new Star(textureAtlas);

        stars = new Star[STAR_COUNT];

        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(textureAtlas);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        drow();
    }

    public void update(float delta) {

//        if (btExit.isMe(this.move)) {
//            System.out.println(" IS MEEEEE !!!");
//        }

//        btExit.zoomInZoomOutOnHover(this.move);
//        btPlay.zoomInZoomOutOnHover(this.move);
//        btPlay.zoomInZoomOutOnPressed(touch);

        btExit.zoomInZoomOutOnHoverOnPressed(this.touch, this.move);
        btPlay.zoomInZoomOutOnHoverOnPressed(this.touch, this.move);

//        if (btExit.close(this.unTouch)) System.exit(0);//this.hide();
        if (btExit.close(this.unTouch)) Gdx.app.exit();

        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
//        touch.set(empty);
    }

    public void drow() {
        Gdx.gl.glClearColor(0, 0, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);

        star.draw(batch);

        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }

        btExit.draw(batch);
        btPlay.draw(batch);

        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i = 0; i < stars.length; i++) {
            stars[i].resize(worldBounds);
        }

        star.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        textureAtlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
//        System.out.println("MENU_SCREEN_TOUCH_DOWN");
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        System.out.println("+++ touchUp touch.x = " + touch.x + " touch.y = " + touch.y);
        touch.set(empty);
        return false;
    }
}