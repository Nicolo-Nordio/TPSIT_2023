package com.mygdx.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import zucgame.AnimatedSprite;
import zucgame.Parameters;
import zucgame.Sprite;

public class GameDemo extends ApplicationAdapter implements InputProcessor {

    final int camwidth = 4;
    Camera cam;
    SpriteBatch batch;


    Rebel rebel;

    float floorLevel = 0.2f;

    Level level;

    /**
     * Metodo che crea tutti gli aspetti di gioco
     */
    @Override
    public void create() {


        Parameters.setAspectRatio(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        cam = new OrthographicCamera(camwidth, camwidth * Parameters.getInverseAspectRatio());
        cam.position.set(camwidth * 0.5f, camwidth * Parameters.getInverseAspectRatio() * 0.5f, 0);

        batch = new SpriteBatch();


        rebel = new Rebel();
        rebel.setX(-0.5f);
        rebel.setY(floorLevel);

        level = new Level("livello 00", camwidth * Parameters.getInverseAspectRatio());
        level.setRebel(rebel);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {

        level.update();

        ScreenUtils.clear(1, 0, 0, 1);

        cam.update();
        batch.setProjectionMatrix(cam.combined);

        batch.begin();

        level.draw(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}


