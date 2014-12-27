package io.zades.core.managers;

import io.zades.core.CCSCore;
import io.zades.core.gamestates.*;

import java.util.HashMap;

/**
 * Class contains all logic to manage the state of the game
 * Created by Darren on 10/16/2014.
 */
public class GameStateManager
{
	public static enum GAME_STATE
	{
		PRELOAD,
		MAIN_MENU,
		SONG_SELECTION,
		PLAY_GAME,
		OPTIONS,
		SONG_PAUSED,
		SONG_LOST,
		SONG_WON_
	}

	private HashMap<GAME_STATE, AbstractGameState> gameStateList;
	private GAME_STATE currentState;
	private CCSCore game;

	public GameStateManager(CCSCore game)
	{
		this.game = game;
		this.gameStateList = new HashMap<GAME_STATE, AbstractGameState>();
		this.currentState = null;
	}

	public void initStates()
	{
		//TODO: maybe use function pointers for this part (anon classes)

		PreloadGameState 		preloadState 		= new PreloadGameState(game);
		MainMenuGameState 		mainMenuState 		= new MainMenuGameState(game);
		SongSelectionGameState 	songSelectionState 	= new SongSelectionGameState(game);
		PlayGameState	 		playGameState 		= new PlayGameState(game);
//		OptionsState 	optionsState 	= new OptionsState();
//		PauseState 		pauseState 		= new PauseState();
//		GameOverState 	gameOverState 	= new GameOverState();
//		SongEndedState 	songEndedState 	= new SongEndedState();

		this.getGameStateList().put(GAME_STATE.PRELOAD, preloadState);
		this.getGameStateList().put(GAME_STATE.MAIN_MENU, mainMenuState);
		this.getGameStateList().put(GAME_STATE.SONG_SELECTION, songSelectionState);
		this.getGameStateList().put(GAME_STATE.PLAY_GAME, playGameState);

		this.setCurrentState(GAME_STATE.PRELOAD);
	}

	public HashMap<GAME_STATE, AbstractGameState> getGameStateList()
	{
		return gameStateList;
	}

	public AbstractGameState getCurrentState()
	{
		return this.gameStateList.get(this.currentState);
	}

	public void setCurrentState(GAME_STATE currentState)
	{
		this.gameStateList.get(currentState).enterState();
		this.currentState = currentState;
	}
}
