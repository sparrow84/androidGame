package com.github.sparrow84.jagd.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class ScaledTouchUpButton extends Sprite {

    public static final float PRESS_SCALE = 0.9f;

    private int pointer;
    private boolean isPressed;
    private ActionListener actionListener;
    public ScaledTouchUpButton(TextureRegion region, ActionListener actionListener) {
        super(region);
        this.actionListener = actionListener;
        setHeightProportion(0.15f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {

        boolean res = false;

        if (isPressed || !isMe(touch)) {
            res = false;
        }
        this.pointer = pointer;
        this.scale = PRESS_SCALE;
        this.isPressed = true;
        return res;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        boolean res = false;
        if (this.pointer != pointer || !isPressed) return res;
        if (isMe(touch)) {
            actionListener.actionPerformed(this);
        }
        isPressed = false;
        scale =1f;
        return res;
    }
}
