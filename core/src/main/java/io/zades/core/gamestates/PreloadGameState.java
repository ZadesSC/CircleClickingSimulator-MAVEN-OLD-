package io.zades.core.gamestates;

import com.badlogic.gdx.Gdx;
import io.zades.core.CCSCore;
import io.zades.core.managers.GameStateManager;

/**
 * Created by Darren on 10/22/2014.
 */
public class PreloadGameState extends AbstractGameState
{
	public PreloadGameState(CCSCore game)
	{
		super(GameStateManager.GAME_STATE.PRELOAD, game);

		//Begin loading and starting stuff
		game.ccsSkinManager.initAllSkins();
		game.beatmapManager.initAllBeatmaps();
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);

		if(this.game.assetManager.update())
		{
			//loading complete, moving on
			Gdx.app.debug(PreloadGameState.class.toString(), "Loading complete, moving on to main menu");
			this.game.gameStateManager.setCurrentState(GameStateManager.GAME_STATE.MAIN_MENU);
		}

		//loading debug
		Gdx.app.debug(PreloadGameState.class.toString(), "Current loading progress: " + this.game.assetManager.getProgress());
	}

	/**
	 * @param width
	 * @param height
	 * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
	 */
	@Override
	public void resize(int width, int height)
	{

	}

	/**
	 * Called when this screen becomes the current screen for a {@link com.badlogic.gdx.Game}.
	 */
	@Override
	public void show()
	{

	}

	/**
	 * Called when this screen is no longer the current screen for a {@link com.badlogic.gdx.Game}.
	 */
	@Override
	public void hide()
	{

	}

	/**
	 * @see com.badlogic.gdx.ApplicationListener#pause()
	 */
	@Override
	public void pause()
	{

	}

	/**
	 * @see com.badlogic.gdx.ApplicationListener#resume()
	 */
	@Override
	public void resume()
	{

	}

	/**
	 * Called when this screen should release all resources.
	 */
	@Override
	public void dispose()
	{

	}
}
