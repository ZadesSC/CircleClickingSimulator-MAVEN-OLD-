package io.zades.circleclickingsimulator.game.gamestate;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Class contains all logic to manage the state of the game
 * Created by Darren on 10/16/2014.
 */
public class StateManager
{
	public static final int PRELOAD_STATE 		= 0;
	public static final int MAIN_MENU_STATE 	= 1;
	public static final int SONG_SELECT_STATE 	= 2;
	public static final int PLAY_GAME_STATE 	= 3;
	public static final int OPTIONS_STATE 		= 4;
	public static final int PAUSE_STATE 		= 5;
	public static final int GAME_OVER_STATE 	= 6; //might be redundant
	public static final int SONG_ENDED_STATE 	= 7;

	private StateBasedGame game;

	public StateManager(StateBasedGame game)
	{
		this.game = game;
	}

	public void initStates(GameContainer container)
	{
		PreloadState 	preloadState 	= new PreloadState();
		MainMenuState 	mainMenuState 	= new MainMenuState();
		SongSelectState songSelectState = new SongSelectState();
		PlayGameState 	playGameState 	= new PlayGameState();
		OptionsState 	optionsState 	= new OptionsState();
		PauseState 		pauseState 		= new PauseState();
		GameOverState 	gameOverState 	= new GameOverState();
		SongEndedState 	songEndedState 	= new SongEndedState();

		this.game.addState(preloadState);
		this.game.addState(mainMenuState);
		this.game.addState(songSelectState);
		this.game.addState(playGameState);
		this.game.addState(optionsState);
		this.game.addState(pauseState);
		this.game.addState(gameOverState);
		this.game.addState(songEndedState);

		//Get it functional first blah
		this.game.enterState(StateManager.PLAY_GAME_STATE);
	}
}
