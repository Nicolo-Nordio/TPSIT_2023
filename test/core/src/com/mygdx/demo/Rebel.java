package com.mygdx.demo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import zucgame.GraphicObject;
import zucgame.Sprite;

public class Rebel extends GraphicObject {
    private Sprite sprite;
    private Vector2 velocity;

    Rebel(){
        super();

        sprite = new Sprite(new Texture("FIGHTER_01__REBEL.png"));
        sprite.setWidth(3);
        sprite.setOffsetX(-1.5f);
        sprite.setOffsetY(-0.5f);

        velocity = new Vector2(0, 0);
    }

    /**
     * Vari setter
     */
    @Override
    public void setX(float x) {
        super.setX(x);
        sprite.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        sprite.setY(y);
    }

    /**
     * Metodo che disegna la texture
     *
     * @param sb
     */
    @Override
    public void draw(SpriteBatch sb) {
        sprite.draw(sb);
    }
}
