package com.github.sparrow84.jagd.pool;

import com.github.sparrow84.jagd.base.SpritesPool;
import com.github.sparrow84.jagd.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
