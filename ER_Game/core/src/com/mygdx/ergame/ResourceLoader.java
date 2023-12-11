package com.mygdx.ergame;

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
     *
     */
    private static EnumMap<ResourceEnum, Texture[]> mapAnimation = new EnumMap<>(ResourceEnum.class);

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
                    res = new Texture[10];
                    for (int i = 0; i < res.length; i++) {
                        res[i] = new Texture("knight/Knight_02__JUMP_00" + i + ".png");
                        mapAnimation.put(index, res);
                    }
                    break;
                default:
                    res = null;
            }
        }else {
            res = mapAnimation.get(index);
        }
        return res;
    }

}
