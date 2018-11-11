package com.github.sparrow84.jagd.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.ActionListener;
import com.github.sparrow84.jagd.base.Base2DScreen;
import com.github.sparrow84.jagd.math.Rect;
import com.github.sparrow84.jagd.sprite.Background;
import com.github.sparrow84.jagd.sprite.BtExit;
import com.github.sparrow84.jagd.sprite.BtPlay;
import com.github.sparrow84.jagd.sprite.MessageGameOver;
import com.github.sparrow84.jagd.sprite.Star;


public class MenuScreen extends Base2DScreen implements ActionListener {

    private static final int STAR_COUNT = 256;

    private Game game;

    private Texture bgTexture;
    private Background background;

    private TextureAtlas textureAtlas;
    private Star[] stars;

    private BtExit BtExit;
    private BtPlay BtPlay;

    private MessageGameOver messageGameOver;

    private TextureAtlas textureAtlas2;

    public MenuScreen(Game game) {
        super();
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("bg.png");
        background = new Background(new TextureRegion(bgTexture));
        textureAtlas = new TextureAtlas("menuAtlas.tpack");
        textureAtlas2 = new TextureAtlas("mainAtlas.tpack");
        stars =new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(textureAtlas);
        }
        BtExit = new BtExit(textureAtlas, this);
        BtPlay = new BtPlay(textureAtlas, this);

        messageGameOver = new MessageGameOver(textureAtlas2);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();

    }

    public void update(float delta) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(0.128f, 0.53f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }
        BtExit.draw(batch);
        BtPlay.draw(batch);

        messageGameOver.draw(batch);

        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i = 0; i < stars.length; i++) {
            stars[i].resize(worldBounds);
        }
        BtExit.resize(worldBounds);
        BtPlay.resize(worldBounds);

        messageGameOver.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        textureAtlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        BtExit.touchDown(touch, pointer);
        BtPlay.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        BtExit.touchUp(touch, pointer);
        BtPlay.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }

    @Override
    public void actionPerformed(Object src) {
        if (src == BtExit) {
            Gdx.app.exit();
        } else if (src == BtPlay) {
            game.setScreen(new GameScreen());
        }
    }
}
