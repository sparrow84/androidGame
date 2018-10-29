package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
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

    @Override
    public void resize(Rect worldBounds) {
        this.setScale(0.9f);
    }

    public void zoomInZoomOutOnHover(Vector2 move) {
        if (this.isMe(move)) {
            this.setScale(0.9f);
        } else {
            this.setScale(1f);
        }
    }

}