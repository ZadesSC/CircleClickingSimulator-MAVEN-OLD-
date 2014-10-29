package io.zades.core.objects;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Darren on 10/22/2014.
 */
public class Beatmap
{
	private int osuFileVersion;

	private HashMap<String, String> kvPairs;
	private ArrayList<HitObject> hitObjects;

	public Beatmap()
	{
		this.osuFileVersion = -1;
		this.kvPairs = new HashMap<String, String>();
		this.hitObjects = new ArrayList<HitObject>();
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
}
