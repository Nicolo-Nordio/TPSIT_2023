package com.mygdx.ergame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.ergame.zucgame.AnimatedSprite;
import com.mygdx.ergame.zucgame.GraphicObject;

public class Knight extends GraphicObject {
    enum KNIGHT_STATE {
        IDLE,
        WALK
    }

    private AnimatedSprite sprite;
    private Texture[] animIdle;
    private Texture[] animWalk;
    private boolean isWalk;
    private KNIGHT_STATE state;

    /**
     * Costruttore che attribuisce i due Texture[] con i vari frames
     */
    Knight() {
        super();

        animIdle = ResourceLoader.getAnimation(ResourceEnum.KN_IDLE);
        animWalk = ResourceLoader.getAnimation(ResourceEnum.KN_WALK);

        sprite = new AnimatedSprite(animIdle);
        sprite.setWidth(3);
        sprite.setOffsetX(-1.5f);
        sprite.setOffsetY(-0.5f);

        state = KNIGHT_STATE.IDLE;
        isWalk = false;
    }

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

    public void setWalk(boolean walk) {
        isWalk = walk;
    }

    @Override
    public void draw(SpriteBatch sb) {
        sprite.draw(sb);
    }

    /**
     * Questo metodo viene chiamato periodicamente per aggiornare la posizione del cavaliere sullo schermo
     * e per gestire le varie situazioni in cui il cavaliere si trova (Idle, Walk)
     */
    public void update() {
        switch (state) {
            case IDLE:
                if (isWalk) {
                    state = KNIGHT_STATE.WALK;
                    sprite.setAnimation(animWalk);
                }
                sprite.update();
                break;

            case WALK:
                if (!isWalk) {
                    state = KNIGHT_STATE.IDLE;
                    sprite.setAnimation(animIdle);
                }
                sprite.update();
                break;
        }
    }
}
