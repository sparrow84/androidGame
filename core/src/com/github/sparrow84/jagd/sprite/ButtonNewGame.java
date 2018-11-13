package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.ActionListener;
import com.github.sparrow84.jagd.base.ScaledTouchUpButton;
import com.github.sparrow84.jagd.base.Sprite;
import com.github.sparrow84.jagd.math.Rect;

public class ButtonNewGame extends ScaledTouchUpButton {

    public ButtonNewGame(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("button_new_game"), actionListener);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(-0.2f);
        setRight(halfWidth);
    }

}
