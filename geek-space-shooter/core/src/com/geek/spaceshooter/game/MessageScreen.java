package com.geek.spaceshooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MessageScreen implements Screen{
    private SpaceGame game;
    private SpriteBatch batch;
    private Background background;
    private Vector2 emptyVelocity = new Vector2(0, 0);
    private TextureRegion texStart;
    private TextureRegion texExit;
    private Rectangle rectStart;
    private Rectangle rectExit;
    private BitmapFont font;
    private String message;
    private int score;

    private static final int MESSAGE_X = 580;
    private static final int MESSAGE_Y = SpaceGame.SCREEN_HEIGHT - SpaceGame.SCREEN_HEIGHT / 5;
    private static final int SCORE_X = 545;
    private static final int SCORE_Y = SpaceGame.SCREEN_HEIGHT - SpaceGame.SCREEN_HEIGHT / 3;
    private static final int START_X = 256;
    private static final int START_Y = 150;
    private static final int EXIT_X = 1280 - 512;
    private static final int EXIT_Y = 150;


    private MyInputProcessor mip;

    public MessageScreen(SpaceGame game, SpriteBatch batch) {
        this.game = game;
        this.batch = batch;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void show() {
        System.out.println(message);
        Assets.getInstance().loadAssets(ScreenType.GAMEOVER);
        TextureAtlas atlas = Assets.getInstance().mainAtlas;
        font = Assets.getInstance().assetManager.get("font2.fnt", BitmapFont.class);
        background = new Background(atlas.findRegion("star16"));
        texExit = atlas.findRegion("btExit");
        texStart = atlas.findRegion("btPlay");
        rectStart = new Rectangle(START_X, START_Y, texStart.getRegionWidth(), texStart.getRegionHeight());
        rectExit = new Rectangle(EXIT_X, EXIT_Y, texExit.getRegionWidth(), texExit.getRegionHeight());
        mip = (MyInputProcessor) Gdx.input.getInputProcessor();
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(((SpaceGame) game).getCamera().combined);
        batch.begin();
        background.render(batch);
        batch.draw(texStart, rectStart.x, rectStart.y);
        batch.draw(texExit, rectExit.x, rectExit.y);
        font.draw(batch, "Your score is: " + String.valueOf(score), SCORE_X, SCORE_Y);
        font.draw(batch, message, MESSAGE_X, MESSAGE_Y);
        batch.end();
    }

    public void update(float dt) {
        background.update(dt, emptyVelocity);
        if (mip.isTouchedInArea(rectStart) != -1) {
            game.setScreen(game.getGameScreen());
        }
        if (mip.isTouchedInArea(rectExit) != -1) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
        game.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Assets.getInstance().clear();
    }

    @Override
    public void dispose() {
        Assets.getInstance().clear();
    }
}
