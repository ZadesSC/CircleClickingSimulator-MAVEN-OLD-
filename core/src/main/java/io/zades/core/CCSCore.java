package io.zades.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import io.zades.core.managers.BeatmapManager;
import io.zades.core.managers.CCSSkinManager;
import io.zades.core.managers.GameStateManager;

public class CCSCore implements ApplicationListener
{
	//Global game stuff
	public CCSSkinManager ccsSkinManager;
	public BeatmapManager beatmapManager;
	public GameStateManager gameStateManager;
	public AssetManager assetManager;

	Texture texture;
	SpriteBatch batch;
	float elapsed;

	@Override
	public void create ()
	{
		//Cross platform application settings go here
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		this.ccsSkinManager = new CCSSkinManager(this);
		this.beatmapManager = new BeatmapManager();
		this.gameStateManager = new GameStateManager(this);
		this.assetManager = new AssetManager();

		this.gameStateManager.initStates();

		texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
		batch = new SpriteBatch();
	}

	@Override
	public void resize (int width, int height)
	{
	}

	@Override
	public void render ()
	{
		this.gameStateManager.getCurrentState().render(Gdx.graphics.getDeltaTime());

//		elapsed += Gdx.graphics.getDeltaTime();
//		Gdx.gl.glClearColor(0, 0, 0, 0);
//		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(texture, 100+100*(float)Math.cos(elapsed), 100+25*(float)Math.sin(elapsed));
//		batch.end();
	}

	@Override
	public void pause ()
	{
	}

	@Override
	public void resume ()
	{
	}

	@Override
	public void dispose ()
	{
	}
}
