package io.zades.core.objects.beatmaps;

import java.util.ArrayList;
import java.util.List;

/**
 * The model for a song object
 * Created by Darren on 10/29/2014.
 */
public class SongData
{
	private String title;
	private String titleUnicode;
	private String artist;
	private String creator;
	private String difficulty;
	private List<String> source;
	private List<String> tags;
	private long osuBeatmapId;
	private long osuBeatmapSetId;

	public SongData()
	{
		this.setTitle(null);
		this.setTitleUnicode(null);
		this.setArtist(null);
		this.setCreator(null);
		this.setDifficulty(null);
		this.setSource(new ArrayList<>());
		this.setTags(new ArrayList<>());
		this.setOsuBeatmapId(-1);
		this.setOsuBeatmapSetId(-1);
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitleUnicode()
	{
		return titleUnicode;
	}

	public void setTitleUnicode(String titleUnicode)
	{
		this.titleUnicode = titleUnicode;
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public String getCreator()
	{
		return creator;
	}

	public void setCreator(String creator)
	{
		this.creator = creator;
	}

	public String getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
	}

	public List<String> getSource()
	{
		return source;
	}

	public void setSource(List<String> source)
	{
		this.source = source;
	}

	public List<String> getTags()
	{
		return tags;
	}

	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}

	public long getOsuBeatmapId()
	{
		return osuBeatmapId;
	}

	public void setOsuBeatmapId(long osuBeatmapId)
	{
		this.osuBeatmapId = osuBeatmapId;
	}

	public long getOsuBeatmapSetId()
	{
		return osuBeatmapSetId;
	}

	public void setOsuBeatmapSetId(long osuBeatmapSetId)
	{
		this.osuBeatmapSetId = osuBeatmapSetId;
	}
}
