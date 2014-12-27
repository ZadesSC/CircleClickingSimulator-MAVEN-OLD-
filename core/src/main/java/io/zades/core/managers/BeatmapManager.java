package io.zades.core.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import io.zades.core.CCSCore;
import io.zades.core.io.OsuBeatmapFileParser;
import io.zades.core.objects.beatmaps.Beatmap;

import java.util.HashMap;

/**
 * Created by Darren on 10/22/2014.
 */
public class BeatmapManager
{
	public static final String BEATMAP_PATH = "Beatmaps/";

	private CCSCore game;

	private HashMap<FileHandle, Beatmap> listOfBeatmapsByDirectory;

	public BeatmapManager(CCSCore game)
	{
		this.game = game;
		this.setListOfBeatmapsByDirectory(new HashMap<FileHandle, Beatmap>());

	}

	public void initAllBeatmaps()
	{

		//TODO: error check for the used directory (is a directory, etc)
		if(!this.locateBeatmapDirectory().exists() || !this.locateBeatmapDirectory().isDirectory())
		{
			Gdx.app.debug(BeatmapManager.class.toString(), "Beatmaps folder doesn't exist, generating...");
			this.locateBeatmapDirectory().mkdirs();
		}
		else
		{
			Gdx.app.debug(BeatmapManager.class.toString(), "Beatmaps folder exists, moving on...");
		}

		FileHandle[] files = this.locateBeatmapDirectory().list();

		for(FileHandle file: files)
		{
			if(file.isDirectory())
			{
				//TODO: loading the files needs to be done via asset manager
				Gdx.app.debug(BeatmapManager.class.toString(), "Folder: " + file.toString());

				//TODO: move to loader
				FileHandle[] osuFiles = file.list(".osu");
				for(FileHandle osuFile: osuFiles)
				{
					Gdx.app.debug(BeatmapManager.class.toString(), "File: " + osuFile.toString());

					Beatmap beatmap = new Beatmap();
					OsuBeatmapFileParser parser = new OsuBeatmapFileParser(this.game);
					beatmap = parser.parseFile(beatmap, osuFile);
					beatmap.setDirectoryLocation(file.toString());
					beatmap.setFileLocation(osuFile.toString());
					this.getListOfBeatmapsByDirectory().put(osuFile, beatmap);

					//Gdx.app.debug(BeatmapManager.class.toString(), new Json().prettyPrint(beatmap));

				}
			}
		}
	}

	private FileHandle locateBeatmapDirectory()
	{
		//TODO: change it so users can change the directory, which is going to be a pain in the ass
		return Gdx.files.local(BEATMAP_PATH);
	}

	public HashMap<FileHandle, Beatmap> getListOfBeatmapsByDirectory() {
		return listOfBeatmapsByDirectory;
	}

	public void setListOfBeatmapsByDirectory(HashMap<FileHandle, Beatmap> listOfBeatmapsByDirectory) {
		this.listOfBeatmapsByDirectory = listOfBeatmapsByDirectory;
	}
}
