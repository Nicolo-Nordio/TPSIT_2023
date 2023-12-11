package com.mygdx.ergame.zucgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite extends GraphicObject{
    private Texture frame;

    /**
     * Rappresenta un oggetto da disegnare sullo schermo con le sue informazioni posizionali
     * @param img
     */
    public Sprite(Texture img){
        frame = img;
        x = 0;
        y = 0;
        width = 1;
        height = (float) frame.getHeight() / frame.getWidth();
    }

    /**
     *
     * @param w
     */
    @Override
    public void setWidth(float w){
        super.setWidth(w);
        super.setHeight(w * frame.getHeight() / frame.getWidth());
    }

    /**
     *
     * @param h
     */
    @Override
    public void setHeight(float h) {
        super.setHeight(h);
        super.setWidth(h * frame.getHeight() / frame.getWidth());
    }

    /**
     * Renderizza l'immagine di riferimento sullo schermo
     * @param sb
     */
    public void draw(SpriteBatch sb){
        sb.draw(frame, x, y, width, height);
    }
}
