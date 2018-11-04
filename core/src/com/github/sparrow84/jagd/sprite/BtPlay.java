package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.ActionListener;
import com.github.sparrow84.jagd.base.ScaledTouchUpButton;
import com.github.sparrow84.jagd.math.Rect;

public class BtPlay extends ScaledTouchUpButton {

    public BtPlay(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btPlay"), actionListener);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setLeft(worldBounds.getLeft());
    }
}
