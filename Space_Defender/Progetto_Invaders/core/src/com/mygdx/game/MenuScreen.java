package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {

    private static final float EXIT_BUTTON_WIDTH = 300;
    private static final float EXIT_BUTTON_HEIGHT = 150;
    private static final float EXIT_BUTTON_Y = 45;

    private static final float PLAY_BUTTON_WIDTH = 330;
    private static final float PLAY_BUTTON_HEIGHT = 150;
    private static final float PLAY_BUTTON_Y = 225;

    private static final float TITLE_WIDTH_1 = 300;
    private static final float TITLE_HEIGHT_1 = 300;
    private static final float TITLE_Y_1 = 450;

    private static final float TITLE_WIDTH_2 = 300;
    private static final float TITLE_HEIGHT_2 = 300;
    private static final float TITLE_Y_2 = 450;

    Texture playButtonActive;
    Texture playButtonInactive;

    Texture exitButtonActive;
    Texture exitButtonInactive;

    Texture title1;
    Texture title2;

    SpaceGame game;

    MenuScreen(SpaceGame game){
        this.game = game;
        playButtonActive = new Texture("play_button_active.png");
        playButtonInactive = new Texture("play_button_inactive.png");

        exitButtonActive = new Texture("exit_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");

        title1 = new Texture("titles/title1.png");
        title2 = new Texture("titles/title2.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0f, 0f, 0f, 1);

        game.batch.begin();


        float x = (float) SpaceGame.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
        if(Gdx.input.getX() < x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > x && SpaceGame.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && SpaceGame.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y){
            game.batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        } else {
            game.batch.draw(exitButtonInactive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        x = (float) SpaceGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
        if(Gdx.input.getX() < x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > x && SpaceGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && SpaceGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y){
            game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        } else {
            game.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }

        x = (float) SpaceGame.WIDTH / 2 - TITLE_WIDTH_1 / 2;
        game.batch.draw(title1, x, TITLE_Y_1, TITLE_WIDTH_1, TITLE_HEIGHT_1);

        x = (float) SpaceGame.WIDTH / 2 - TITLE_WIDTH_1 / 2;
        //game.batch.draw(title2, x, TITLE_Y_2, TITLE_WIDTH_2, TITLE_HEIGHT_2);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
