package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Sprite;
import com.github.sparrow84.jagd.math.Rect;

import static ru.geekbrains.math.Rnd.*;

public class Star extends Sprite {

    private Vector2 v = new Vector2();
    private Rect worldBounds;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        setHeightProportion(0.01f);
        this.v.set(ru.geekbrains.math.Rnd.nextFloat(0.001f, 0.005f), ru.geekbrains.math.Rnd.nextFloat(-0.5f, -0.1f));
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float podX = nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float podY = nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(podX, podY);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkAndHandleBounds();
    }

    private void checkAndHandleBounds() {
        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if (getLeft() < worldBounds.getRight()) setRight(worldBounds.getLeft());
        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
        if (getBottom() < worldBounds.getTop()) setTop(worldBounds.getBottom());
    }
}
