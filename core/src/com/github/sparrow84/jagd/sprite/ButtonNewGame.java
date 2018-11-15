package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.ActionListener;
import com.github.sparrow84.jagd.base.ScaledTouchUpButton;

public class ButtonNewGame extends ScaledTouchUpButton {
    public ButtonNewGame(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("button_new_game"), actionListener);
        setHeightProportion(0.05f);
        setTop(-0.012f);
    }
}
