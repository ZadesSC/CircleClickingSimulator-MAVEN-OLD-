package io.zades.core.objects.beatmaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the editor data in beatmaps
 * Created by Darren on 10/29/2014.
 */
public class EditorData
{
	private List<Long> bookmarks;
	private float distanceSpacing;
	private int beatDivisor;
	private int gridSize;
	private int timeLineZoom;

	public EditorData()
	{
		this.setBookmarks(new ArrayList<>());
		this.setDistanceSpacing(1);
		this.setBeatDivisor(4);
		this.setGridSize(4);
		this.setTimeLineZoom(1);
	}

	public List<Long> getBookmarks()
	{
		return bookmarks;
	}

	public void setBookmarks(List<Long> bookmarks)
	{
		this.bookmarks = bookmarks;
	}

	public float getDistanceSpacing()
	{
		return distanceSpacing;
	}

	public void setDistanceSpacing(float distanceSpacing)
	{
		this.distanceSpacing = distanceSpacing;
	}

	public int getBeatDivisor()
	{
		return beatDivisor;
	}

	public void setBeatDivisor(int beatDivisor)
	{
		this.beatDivisor = beatDivisor;
	}

	public int getGridSize()
	{
		return gridSize;
	}

	public void setGridSize(int gridSize)
	{
		this.gridSize = gridSize;
	}

	public int getTimeLineZoom()
	{
		return timeLineZoom;
	}

	public void setTimeLineZoom(int timeLineZoom)
	{
		this.timeLineZoom = timeLineZoom;
	}
}
