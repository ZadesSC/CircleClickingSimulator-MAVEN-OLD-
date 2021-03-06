package io.zades.core.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import io.zades.core.CCSCore;
import io.zades.core.io.OsuBeatmapFileParser;
import io.zades.core.managers.GameStateManager;
import io.zades.core.objects.HitObject;

/**
 * Created by Darren on 10/22/2014.
 */
public class PreloadGameState extends AbstractGameState
{
	public PreloadGameState(CCSCore game)
	{
		super(GameStateManager.GAME_STATE.PRELOAD, game);

		//Begin loading and starting stuff
		//TODO: This needs to be async
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
			//short circuit to play game state
			Gdx.app.debug(PreloadGameState.class.toString(), "Loading complete, moving on to play game state");
			this.game.gameStateManager.setCurrentState(GameStateManager.GAME_STATE.PLAY_GAME);
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
