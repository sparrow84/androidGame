package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.ActionListener;
import com.github.sparrow84.jagd.base.ScaledTouchUpButton;
import com.github.sparrow84.jagd.math.Rect;

public class BtExit extends ScaledTouchUpButton {

    public BtExit(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), actionListener);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }

}
