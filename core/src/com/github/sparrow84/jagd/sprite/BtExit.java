package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.ScaledTouchUpButton;
import com.github.sparrow84.jagd.math.Rect;

public class BtExit extends ScaledTouchUpButton {

    private Rect worldBounds;

    private Vector2 tmpPress;
    private Vector2 empty;

    public BtExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"),this);
        setHeightProportion(0.2f);
        pos.set(-0.25f,-0.35f);

        tmpPress = new Vector2();
        empty = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.setScale(0.9f);
    }

    public void zoomInZoomOutOnHover(Vector2 move) {
        if (this.isMe(move)) {
            this.setScale(1.1f);
        } else {
            this.setScale(1f);
        }
    }

    public void zoomInZoomOutOnPressed(Vector2 touch) {
        //FIXME
        if (this.isMe(touch)) {
            this.setScale(1.1f);
        } else {
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

    public boolean close(Vector2 touch) {
        if (this.isMe(touch)) return true;
        return false;
    }

}
