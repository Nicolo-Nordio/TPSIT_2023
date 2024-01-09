package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    static final float SPEED = 350;

    static final float SHIP_WIDTH = 100;
    static final float SHIP_HEIGHT = 100; //fare inverseAspectRatio

    Texture spaceShip;

    float x;
    float y;

    SpaceGame game;

    GameScreen(SpaceGame game){
        this.game = game;
        y = 15;
        x = (float) SpaceGame.WIDTH / 2 - SHIP_WIDTH/2;
        spaceShip = new Texture("battleships/FIGHTER_01__REBEL.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= SPEED * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += SPEED * Gdx.graphics.getDeltaTime();
        }

        ScreenUtils.clear(0, 0, 0, 1);

        game.batch.begin();
        game.batch.draw(spaceShip, x, y, SHIP_WIDTH, SHIP_HEIGHT);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
