package com.github.sparrow84.jagd.pool;

import com.badlogic.gdx.audio.Sound;
import com.github.sparrow84.jagd.base.SpritesPool;
import com.github.sparrow84.jagd.math.Rect;
import com.github.sparrow84.jagd.sprite.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {
    private BulletPool bulletPool;
    private Rect worldBounds;
    private Sound shootSound;

    public EnemyPool(BulletPool bulletPool, Rect worldBounds, Sound shootSound) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.shootSound = shootSound;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, worldBounds, shootSound);
    }
}
