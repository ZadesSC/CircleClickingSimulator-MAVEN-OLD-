package io.zades.circleclickingsimulator.game.gamestates;

import io.zades.circleclickingsimulator.game.managers.GameStateManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Darren on 10/16/2014.
 */
public class PlayGameState extends BasicGameState
{
	private int stateId = GameStateManager.PLAY_GAME_STATE;
	/**
	 * @see org.newdawn.slick.state.GameState#getID()
	 */
	@Override
	public int getID()
	{
		return this.stateId;
	}

	/**
	 * Initialise the state. It should load any resources it needs at this stage
	 *
	 * @param container The container holding the game
	 * @param game      The game holding this state
	 * @throws org.newdawn.slick.SlickException Indicates a failure to initialise a resource for this state
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{

	}

	/**
	 * Render this state to the game's graphics context
	 *
	 * @param container The container holding the game
	 * @param game      The game holding this state
	 * @param g         The graphics context to render to
	 * @throws org.newdawn.slick.SlickException Indicates a failure to render an artifact
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{

	}

	/**
	 * Update the state's logic based on the amount of time thats passed
	 *
	 * @param container The container holding the game
	 * @param game      The game holding this state
	 * @param delta     The amount of time thats passed in millisecond since last update
	 * @throws org.newdawn.slick.SlickException Indicates an internal error that will be reported through the
	 *                                          standard framework mechanism
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{

	}
}
