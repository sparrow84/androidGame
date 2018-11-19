package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.github.sparrow84.jagd.base.Sprite;
import com.github.sparrow84.jagd.math.Rect;

public class LifeIndicator extends Sprite {

    private int size;

    public LifeIndicator(TextureAtlas atlas, Rect worldBounds, int lifeCount) {
        super(atlas.findRegion("lifeIndicator"));
        setHeightProportion(0.02f);
        setTop(0.47f);
        size = lifeCount;
    }

    public void draw(SpriteBatch batch, int size) {
//        super.draw(batch);

//        regions[frame].setRegionX(1000);
        regions[frame].setRegionWidth(size);

        batch.draw(
                regions[frame],             //текущий регион
                getLeft(), getBottom(),     // точка отрисовки
                halfWidth, halfHeight,      // точка вращения
                // 0.01f ... 0.35f
                (float) (0.34 - (this.size - size) * 0.0034), getHeight(),    // ширина и высота
                scale, scale,               // масштаб по x и y
                angle                       // угол вращения
        );
    }

    /*

    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame], //текущий регион
                getLeft(), getBottom(), // точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }

    */
}
