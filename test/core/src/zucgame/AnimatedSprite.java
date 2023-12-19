package zucgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimatedSprite extends GraphicObject{
    private Texture[] frames;
    private int currentFrame;

    public AnimatedSprite(){
        this.frames = null;
        this.currentFrame = -1;
    }

    /**
     * Costruttore classe
     * @param frames
     */
    public AnimatedSprite(Texture[] frames){
        this.setAnimation(frames);
    }

    /**
     * Imposta l'animazione dello sprite
     * @param frames
     */
    public void setAnimation(Texture[] frames){
        this.frames = frames;
        this.currentFrame = -1;
    }

    /**
     *
     * @param w
     */
    @Override
    public void setWidth(float w){
        super.setWidth(w);
        if(frames != null) super.setHeight(w * frames[0].getHeight() / frames[0].getWidth());
    }

    /**
     *
     * @param h
     */
    @Override
    public void setHeight(float h) {
        super.setHeight(h);
        if(frames != null) super.setWidth(h * frames[0].getHeight() / frames[0].getWidth());
    }

    /**
     * Aggiorna la posizione dell'array
     */
    public void update(){
        currentFrame++;
        if(currentFrame == frames.length) currentFrame = 0;
    }

    /**
     * Renderizza l'immagine di riferimento sullo schermo
     * @param sb
     */
    public void draw(SpriteBatch sb){
        sb.draw(frames[currentFrame], x + offsetX, y + offsetY, width, height);
    }
}
