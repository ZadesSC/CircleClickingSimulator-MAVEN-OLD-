package io.zades.circleclickingsimulator.game.gamestates;

import io.zades.circleclickingsimulator.game.Game;
import io.zades.circleclickingsimulator.game.managers.GameStateManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Darren on 10/16/2014.
 */
public class PreloadState extends BasicGameState
{
	private final int stateId = GameStateManager.PRELOAD_STATE;
	private final ExecutorService pool = Executors.newFixedThreadPool(2);

	private Future preloader;

	private DeferredResource nextResource;
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
		//TODO: load splash
		//TODO: CASTS ARE BAD AND I SHOULD FEEL BAD
		//this.preloader = this.preload((Game) game);
		LoadingList.setDeferredLoading(true);
		((Game)game).getSkinManager().initAllSkins();
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
		if (nextResource != null) {
			g.drawString("Loading: "+nextResource.getDescription(), 100, 100);
		}

		int total = LoadingList.get().getTotalResources();
		int loaded = LoadingList.get().getTotalResources() - LoadingList.get().getRemainingResources();

		float bar = loaded / (float) total;
		g.fillRect(100,150,loaded*5,20);
		g.drawRect(100,150,total*5,20);
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
		if (nextResource != null) {
			try {
				nextResource.load();

				Log.debug("Loading skin resource: " + nextResource.getDescription());
				// slow down loading for example purposes
				//try { Thread.sleep(10); } catch (Exception e) {}

			} catch (IOException e) {
				throw new SlickException("Failed to load: "+nextResource.getDescription(), e);
			}

			nextResource = null;
		}

		if (LoadingList.get().getRemainingResources() > 0) {
			nextResource = LoadingList.get().getNext();
		}
		else
		{
			//ゲームを始めましょうか
			//Short circuit to play game for now
			game.enterState(GameStateManager.PLAY_GAME_STATE);
		}
	}

	/**
	 * Used to preload game data asynchronously
	 * TODO: consider using the spring framework
	 * @return True if its done (kinda pointless but whatever
	 */
	private Future<Boolean> preload(final Game game)
	{
		return this.pool.submit(new Callable<Boolean>()
		{
			@Override
			public Boolean call() throws Exception
			{
				game.getSkinManager().initAllSkins();
				return true;
			}
		});
	}
}
