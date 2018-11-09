package com.github.sparrow84.jagd.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Ship;
import com.github.sparrow84.jagd.math.Rect;
import com.github.sparrow84.jagd.pool.BulletPool;


public class Enemy extends Ship {
    private Vector2 v0 = new Vector2();
    private Vector2 speedOfAppearance = new Vector2();

    public Enemy(BulletPool bulletPool, Rect worldBounds, Sound shootSound) {
        super(shootSound);
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.v.set(v0);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if (getTop() > worldBounds.getTop()) {
            pos.mulAdd(speedOfAppearance, delta);
        } else if (getBottom() < worldBounds.getBottom()) {
            pos.mulAdd(speedOfAppearance, delta);
        } else {
            pos.mulAdd(v, delta);
        }

        reloadTimer += delta;

        if (reloadTimer >= reloadInterval) {
            shoot();
            reloadTimer = 0f;
        }

        if (getTop() < worldBounds.getBottom()) destroy();
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            Vector2 speedOfAppearance,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int bulletDamage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.speedOfAppearance.set(speedOfAppearance);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0f, bulletVY);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.hp = hp;
        setHeightProportion(height);
        v.set(v0);
    }

}
