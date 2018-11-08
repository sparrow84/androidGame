package com.github.sparrow84.jagd.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.math.Rect;
import com.github.sparrow84.jagd.pool.BulletPool;
import com.github.sparrow84.jagd.sprite.Bullet;

public class Ship extends Sprite {
    protected Vector2 v = new Vector2();
    protected BulletPool bulletPool;
    protected Rect worldBounds;

    protected Vector2 bulletV = new Vector2();
    protected float bulletHeight;
    protected int bulletDamage;

    protected float reloadInterval;
    protected float reloadTimer;

    protected int hp;
    protected TextureRegion bulletRegion;

    private Sound shootSound;

    public Ship(TextureRegion region, int rows, int cols, int frames, Sound shootSound) {
        super(region, rows, cols, frames);
        this.shootSound = shootSound;
    }

    public Ship(Sound shootSound) {
        this.shootSound = shootSound;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    protected void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, bulletDamage);
        shootSound.setVolume(shootSound.play(),0.1f);
//        shootSound.play();
    }
}
