package io.zades.circleclickingsimulator.game;

import io.zades.circleclickingsimulator.game.managers.GameStateManager;
import io.zades.circleclickingsimulator.game.managers.SkinManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This class initialize basic game data and classes, it should not do anything else
 * Created by Darren on 10/16/2014.
 */
public class Game extends StateBasedGame
{
	private GameStateManager gameStateManager;
	private SkinManager skinManager;

	public Game(String title)
	{
		super(title);
		this.setGameStateManager(new GameStateManager(this));
		this.setSkinManager(new SkinManager(this));
	}

	/**
	 * Initialise the list of states making up this game
	 *
	 * @param container The container holding the game
	 * @throws org.newdawn.slick.SlickException Indicates a failure to initialise the state based game resources
	 */
	@Override
	public void initStatesList(GameContainer container)throws SlickException
	{
		this.getGameStateManager().initStates(container);
	}

	public GameStateManager getGameStateManager()
	{
		return gameStateManager;
	}

	public void setGameStateManager(GameStateManager gameStateManager)
	{
		this.gameStateManager = gameStateManager;
	}

	public SkinManager getSkinManager()
	{
		return skinManager;
	}

	public void setSkinManager(SkinManager skinManager)
	{
		this.skinManager = skinManager;
	}
}
