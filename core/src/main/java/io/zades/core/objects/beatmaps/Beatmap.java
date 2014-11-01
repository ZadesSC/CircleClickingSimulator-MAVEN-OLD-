package io.zades.core.objects.beatmaps;

import io.zades.core.objects.HitObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Darren on 10/22/2014.
 */
public class Beatmap
{
	private int osuFileVersion;
	private SongData songData;
	private BeatmapData beatmapData;
	private EditorData editorData;
	private DifficultyData difficultyData;

	private HashMap<String, String> kvPairs;
	private ArrayList<HitObject> hitObjects;

	public Beatmap()
	{
		this.osuFileVersion = -1;

		this.songData = new SongData();
		this.beatmapData = new BeatmapData();
		this.editorData = new EditorData();
		this.difficultyData = new DifficultyData();

		this.hitObjects = new ArrayList<>();
		this.kvPairs = new HashMap<>();
	}

	public int getOsuFileVersion()
	{
		return osuFileVersion;
	}

	public void setOsuFileVersion(int osuFileVersion)
	{
		this.osuFileVersion = osuFileVersion;
	}

	public HashMap<String, String> getKvPairs()
	{
		return kvPairs;
	}

	public void setKvPairs(HashMap<String, String> kvPairs)
	{
		this.kvPairs = kvPairs;
	}

	public ArrayList<HitObject> getHitObjects()
	{
		return hitObjects;
	}

	public void setHitObjects(ArrayList<HitObject> hitObjects)
	{
		this.hitObjects = hitObjects;
	}

	public SongData getSongData()
	{
		return songData;
	}

	public void setSongData(SongData songData)
	{
		this.songData = songData;
	}
}
