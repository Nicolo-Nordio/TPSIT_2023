package com.mygdx.ergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.EnumMap;

/**
 * Permette di gestire e caricare le risorse una sola volta attraverso il pattern Singleton
 */
public class ResourceLoader {
    /**
     * Mappa per la gestione delle texture
     */
    private static EnumMap<ResourceEnum, Texture> mapTexture = new EnumMap<>(ResourceEnum.class);

    /**
     * Mappa per la gestione delle animazioni
     */
    private static EnumMap<ResourceEnum, Texture[]> mapAnimation = new EnumMap<>(ResourceEnum.class);

    /**
     * Mappa per la gestione dei suoni
     */
    private static EnumMap<ResourceEnum, Sound> mapSound = new EnumMap<>(ResourceEnum.class);

    /**
     * Ritorna una texture caricandola se necessario
     * @param index
     * @return
     */
    public static Texture getTexture(ResourceEnum index){
        if(!mapTexture.containsKey(index)) {
            switch (index){
                case LOGO:
                    mapTexture.put(index, new Texture("badlogic.jpg"));
                    break;

                case SKY_LEVEL:
                    mapTexture.put(index, new Texture("level00/Sky.png"));
                    break;

                case BG_LEVEL:
                    mapTexture.put(index, new Texture("level00/bg.png"));
                    break;

                case MG_LEVEL:
                    mapTexture.put(index, new Texture("level00/mg.png"));
                    break;

                case FG_LEVEL:
                    mapTexture.put(index, new Texture("level00/fg.png"));
                    break;

                case G_LEVEL:
                    mapTexture.put(index, new Texture("level00/g.png"));
                    break;

                case BUBBLE:
                    mapTexture.put(index, new Texture("bubble.png"));
                    break;

                default:
                    return null;
            }
        }
        return mapTexture.get(index);
    }

    /**
     * Ritorna un'array di texture se necessario
     * @param index
     * @return
     */
    public static Texture[] getAnimation(ResourceEnum index){
        Texture[] res = null;

        if(!mapAnimation.containsKey(index)){
            switch (index){
                case LOGO:
                    break;

                case KN_IDLE:
                    res = new Texture[10];
                    for (int i = 0; i < res.length; i++) {
                        res[i] = new Texture("knight/Knight_02__IDLE_00" + i + ".png");
                        mapAnimation.put(index, res);
                    }
                    break;

                case KN_WALK:
                    res = new Texture[10];
                    for (int i = 0; i < res.length; i++) {
                        res[i] = new Texture("knight/Knight_02__WALK_00" + i + ".png");
                        mapAnimation.put(index, res);
                    }
                    break;

                case KN_RUN:
                    res = new Texture[10];
                    for (int i = 0; i < res.length; i++) {
                        res[i] = new Texture("knight/Knight_02__RUN_00" + i + ".png");
                        mapAnimation.put(index, res);
                    }
                    break;

                case KN_JUMP:
                    res = new Texture[1];
                    for (int i = 4; i < (4 + res.length); i++) {
                        res[i-4] = new Texture("knight/Knight_02__JUMP_00" + i + ".png");
                        mapAnimation.put(index, res);
                    }
                    break;

                case COIN_GOLD:
                    res = new Texture[30];
                    for (int i = 0; i < res.length; i++) {
                        res[i] = new Texture("coin/gold_0" + (i / 3) + ".png");
                        mapAnimation.put(index, res);
                    }
                    break;

                default: return null;
            }
        }else {
            res = mapAnimation.get(index);
        }
        return res;
    }

    public static Sound getSound(ResourceEnum index){
        Sound res = null;

        if(!mapSound.containsKey(index)) {
            switch (index) {
                case AUDIO_COIN:
                    res = Gdx.audio.newSound(Gdx.files.internal("audio/coin.wav"));
                    mapSound.put(index, res);
                    break;

                default:
                    res = null;
                    break;
            }
        }
        else {
            res = mapSound.get(index);
        }

        return res;
    }

}
