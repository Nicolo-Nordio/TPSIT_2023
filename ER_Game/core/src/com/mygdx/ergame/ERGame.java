package com.mygdx.ergame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.ergame.zucgame.AnimatedSprite;
import com.mygdx.ergame.zucgame.Parameters;
import com.mygdx.ergame.zucgame.Sprite;

public class ERGame extends ApplicationAdapter implements InputProcessor {
    final int camwidth = 4;
    Camera cam;
    SpriteBatch batch;
    Sprite logoSprite;

    Knight knight;

    float floorLevel = 0.3f;

    @Override
    public void create() {

        // Risolve il caricamento delle risorse
        ResourceLoader.getAnimation(ResourceEnum.KN_IDLE);
        ResourceLoader.getAnimation(ResourceEnum.KN_WALK);

        Parameters.setAspectRatio(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        cam = new OrthographicCamera(camwidth, camwidth * Parameters.getInverseAspectRatio());
        cam.position.set(camwidth * 0.5f, camwidth * Parameters.getInverseAspectRatio() * 0.5f, 0);

        batch = new SpriteBatch();

        logoSprite = new Sprite(ResourceLoader.getTexture(ResourceEnum.LOGO));
        logoSprite.setWidth(0.5f);
        logoSprite.setX(camwidth - logoSprite.getWidth());
        logoSprite.setY(0);

        knight = new Knight();
        knight.setX(-0.5f);
        knight.setY(floorLevel);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        if (knight.isWalking() && (knight.getX() >= camwidth * 0.25f)) {
            knight.setRun(true);
        } else if (knight.isFalling() && (knight.getY() <= floorLevel)) {
            knight.setRun(true);
            knight.setY(floorLevel);
        }
        knight.update();

        ScreenUtils.clear(1, 0, 0, 1);

        cam.update();
        batch.setProjectionMatrix(cam.combined);

        batch.begin();

        knight.draw(batch);

        logoSprite.draw(batch);
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
        if (knight.isRunning()) {
            knight.setJump(true);
        }

        return true;
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
