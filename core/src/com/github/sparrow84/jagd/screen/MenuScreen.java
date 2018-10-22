package com.github.sparrow84.jagd.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.github.sparrow84.jagd.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private SpriteBatch batch;
    private Texture badLogic;

    private Vector2 pos;
    private Vector2 v;
    private Vector2 horizont;
    private Vector2 destenation;

//    int deltaX, deltaY;
    double speed;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        badLogic = new Texture("badlogic.jpg");
        pos = new Vector2(0,0);
        v = new Vector2(0.05f,0.05f);
        horizont = new Vector2(1, 0);
        destenation = new Vector2(pos.x,pos.y);
        speed = 1;

        //FIXME
//        deltaX = (int) pos.x;
//        deltaY = (int) pos.y;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 1, 15, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(badLogic, pos.x, pos.y);
        batch.end();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("pos.x = " + pos.x + "   pos.y = " + pos.y);
        System.out.println("des.x = " + destenation.x + "   des.y = " + destenation.y);
        if (pos.x != destenation.x || pos.y != destenation.y) {

            System.out.println("\npos.add(v) v.x= " + v.x + "   v.y= " + v.y);
            System.out.println("pos.sub(destenation).len() = " + pos.sub(destenation).len());

            if (pos.sub(destenation).len() < speed) {
                System.out.println("LINE --- 51");
                pos.x = destenation.x;
                pos.y = destenation.y;
            } else {
                System.out.println("\npos  x-> " + pos.x + "   y-> " + pos.y);
                pos.add(v);
                System.out.println("pos  x-> " + pos.x + "   y-> " + pos.y);
            }
        }



    }

    @Override
    public void dispose() {
        batch.dispose();
        badLogic.dispose();
        super.dispose();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

//        deltaX = screenX;
//        deltaY = screenY;

        destenation.set(screenX, Gdx.graphics.getHeight() - screenY);

        v.x = (float) (speed * Math.cos(destenation.dot(horizont)));
        v.y = (float) (speed * Math.sin(destenation.dot(horizont)));

//        v.x = (float) (speed * Math.cos(destenation.nor().dot(horizont.nor())));
//        v.y = (float) (speed * Math.sin(destenation.nor().dot(horizont.nor())));

        System.out.println("\n! ! ! touchDown  v.x = " + v.x + "  v.y = " + v.y);

        return super.touchDown(screenX, screenY, pointer, button);
    }

//    float lineLen(Vector2 v1, Vector2 v2) {
//        float res = (float) Math.sqrt(Math.pow((v1.x - v2.x),2) + Math.pow((v1.y - v2.y),2));
//        System.out.println("lineLen res1 = " + res);
//        System.out.println("lineLen res2 = " + v1.sub(v2).len());
//        return res;
//    }
}