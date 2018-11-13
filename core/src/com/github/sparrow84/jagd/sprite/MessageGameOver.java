package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.ActionListener;
import com.github.sparrow84.jagd.base.ScaledTouchUpButton;
import com.github.sparrow84.jagd.base.Sprite;
import com.github.sparrow84.jagd.math.Rect;

public class MessageGameOver extends Sprite {

    public MessageGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
//        setBottom(worldBounds.getBottom());
//        setRight(worldBounds.getRight());
        setBottom(0);
        setRight(0);
    }

}
