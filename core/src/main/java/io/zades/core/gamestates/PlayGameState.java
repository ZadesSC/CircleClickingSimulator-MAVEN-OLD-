package io.zades.core.gamestates;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import io.zades.core.CCSCore;
import io.zades.core.graphics.BeatmapGraphicsManager;
import io.zades.core.managers.GameStateManager;
import io.zades.core.objects.beatmaps.Beatmap;

/**
 * Created by Darren on 10/26/2014.
 */
public class PlayGameState extends AbstractGameState
{
	private BeatmapGraphicsManager beatmapGraphicsManager;
	private Beatmap currentBeatmap;
	private Music currentSong;

	private long time = 0;

	public PlayGameState(CCSCore game)
	{
		super(GameStateManager.GAME_STATE.PLAY_GAME, game);
	}

	public void enterState()
	{
		//currently just a random beatmap
		this.currentBeatmap = (Beatmap)this.game.beatmapManager.getListOfBeatmapsByDirectory().values().toArray()[0];
		this.beatmapGraphicsManager = new BeatmapGraphicsManager(this.game, this.currentBeatmap);

		//music setup
		//TODO: FIX LE HARDCODE
		//this.currentSong = Gdx.audio.newMusic(Gdx.files.local(this.currentBeatmap.getDirectoryLocation() + this.currentBeatmap.getKvPairs().get("AudioFileName")));
		this.currentSong = Gdx.audio.newMusic(Gdx.files.local(this.currentBeatmap.getDirectoryLocation() + "\\IGNITEup_1.mp3"));
		this.currentSong.setVolume((float)0.1);

		this.beatmapGraphicsManager.init();
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);
		if(!this.currentSong.isPlaying())
		{
			this.currentSong.play();
		}
		this.beatmapGraphicsManager.draw((long)(this.currentSong.getPosition() * 1000));
		Gdx.app.debug(PlayGameState.class.toString(), "Elapsed Time: " + this.currentSong.getPosition() * 1000);
		Gdx.app.debug(PlayGameState.class.toString(), "Delta Time: " + (delta * 1000));

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
