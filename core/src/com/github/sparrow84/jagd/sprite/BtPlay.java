package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Sprite;

public class BtPlay extends Sprite {

    private Vector2 tmpPress;
    private Vector2 empty;

    public BtPlay(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(0.26f);
        pos.set(0.25f,-0.32f);

        tmpPress = new Vector2();
        empty = new Vector2();
    }

    public void zoomInZoomOutOnHover(Vector2 move) {
        if (this.isMe(move)) {
            this.setScale(1.1f);
        } else {
            this.setScale(1f);
        }
    }

    public void zoomInZoomOutOnPressed(Vector2 touch) {
        if (this.isMe(touch)) {
            this.setScale(0.9f);
        } else if (!this.isMe(touch)) {
            this.setScale(1f);
        }
    }

    public void zoomInZoomOutOnHoverOnPressed(Vector2 touch, Vector2 move) {
        if (this.isMe(move)) {
            if (this.isMe(touch)) {
                this.setScale(0.9f);
            } else
                this.setScale(1.1f);
        } else if (!this.isMe(move)) {
            this.setScale(1f);
        }
    }

    public boolean play(Vector2 touch) {
        if (this.isMe(touch)) return true;
        return false;
    }
}
