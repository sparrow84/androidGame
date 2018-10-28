package com.github.sparrow84.jagd.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.math.Rect;

public class Sprite extends Rect {

    protected float angel;
    protected float scale = 1f;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region) {
        if(region == null) {
            throw new NullPointerException("rehionis null");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame], // current region
                getLeft(),      // render point
                getBottom(),    // render point
                halfWidth,      // rotate point
                halfHeight,     // rotate point
                getWidth(),
                getHeight(),
                scale, scale,   // scale x and y
                angel           // rotate angel
        );
    }

    public void setHeightProportion(Float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public void update(float delta) {

    }

    public void resize(Rect worldBounds) {

    }

    public boolean touchDown(Vector2 touch, int pointer) {

        return false;
    }

    public float getAngel() {
        return angel;
    }

    public void setAngel(float angel) {
        this.angel = angel;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
