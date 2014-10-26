package io.zades.core.gamestates;

import io.zades.core.CCSCore;
import io.zades.core.managers.GameStateManager;

/**
 * Created by Darren on 10/26/2014.
 */
public class MainMenuGameState extends AbstractGameState
{

	public MainMenuGameState(CCSCore game)
	{
		super(GameStateManager.GAME_STATE.MAIN_MENU, game);
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);
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
