package com.github.sparrow84.jagd;

import com.badlogic.gdx.Game;
import com.github.sparrow84.jagd.screen.MenuScreen;

public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
