package io.zades.core.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import io.zades.core.CCSCore;
import io.zades.core.managers.GameStateManager;

/**
 * Created by Darren on 10/22/2014.
 */
public abstract class AbstractGameState implements Screen
{
	private GameStateManager.GAME_STATE gameState;
	private CCSCore game;

	public AbstractGameState(GameStateManager.GAME_STATE gameState, CCSCore game)
	{
		this.gameState = gameState;
		this.game = game;
	}

	@Override
	public void render(float delta)
	{
		// the following code clears the screen with the given RGB color (black)
		Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
	}

	public GameStateManager.GAME_STATE getGameState()
	{
		return gameState;
	}
}
