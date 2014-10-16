package io.zades.circleclickingsimulator.game;

import io.zades.circleclickingsimulator.game.gamestate.StateManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This class initialize basic game data and classes, it should not do anything else
 * Created by Darren on 10/16/2014.
 */
public class Game extends StateBasedGame
{
	private StateManager stateManager;
	public Game(String title)
	{
		super(title);
		this.stateManager = new StateManager(this);
	}

	/**
	 * Initialise the list of states making up this game
	 *
	 * @param container The container holding the game
	 * @throws org.newdawn.slick.SlickException Indicates a failure to initialise the state based game resources
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException
	{
		this.stateManager.initStates(container);
	}
}
