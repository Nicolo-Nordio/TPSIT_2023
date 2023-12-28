package com.mygdx.ergame;

import com.badlogic.gdx.audio.Sound;

public class Coin extends GameObject{
    private Sound catchSound;

    Coin(){
        super();

        sprite.setAnimation(ResourceLoader.getAnimation(ResourceEnum.COIN_GOLD));
        sprite.setWidth(0.3f);
        sprite.setOffsetX(-0.15f);
        sprite.setOffsetY(-0.15f);

        setBarycenter(0,0);
        setRadius(0.15f);

        catchSound = ResourceLoader.getSound(ResourceEnum.AUDIO_COIN);
    }

    public void update(){
        sprite.update();
        updatePhysic();
    }

    @Override
    public void manageCollisionWith(GameObject obj) {
        catchSound.play();
        return;
    }
}
