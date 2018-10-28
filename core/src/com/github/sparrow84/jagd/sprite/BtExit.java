package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.Sprite;
import com.github.sparrow84.jagd.math.Rect;
import com.github.sparrow84.jagd.math.Rnd;


public class BtExit extends Sprite {

    private Rect worldBounds;

    public BtExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.2f);
        pos.set(-0.25f,-0.35f);
    }

}
