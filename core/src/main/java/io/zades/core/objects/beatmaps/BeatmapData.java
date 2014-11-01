package io.zades.core.objects.beatmaps;

/**
 * Model for the beatmap general data
 * Created by Darren on 10/29/2014.
 */
public class BeatmapData
{
	private String audioFileName;
	private long audioLeadIn;
	private long audioPreviewTime;
	private boolean hasCountdown;
	private String sampleSet;
	private float stackLeniency;
	private int mode; //0 = osu, 1 = taiko, 2 = catch the beat, 3 = osu mania
	private boolean isLetterboxDuringBreaks;
	private boolean isWidescreenStoryboard;

	public BeatmapData()
	{
		this.setAudioFileName(null);
		this.setAudioLeadIn(0);
		this.setAudioPreviewTime(0);
		this.setHasCountdown(false);
		this.setSampleSet(null);
		this.setStackLeniency(1);
		this.setMode(-1);
		this.setLetterboxDuringBreaks(false);
		this.setWidescreenStoryboard(false);
	}

	public String getAudioFileName()
	{
		return audioFileName;
	}

	public void setAudioFileName(String audioFileName)
	{
		this.audioFileName = audioFileName;
	}

	public long getAudioLeadIn()
	{
		return audioLeadIn;
	}

	public void setAudioLeadIn(long audioLeadIn)
	{
		this.audioLeadIn = audioLeadIn;
	}

	public long getAudioPreviewTime()
	{
		return audioPreviewTime;
	}

	public void setAudioPreviewTime(long audioPreviewTime)
	{
		this.audioPreviewTime = audioPreviewTime;
	}

	public boolean isHasCountdown()
	{
		return hasCountdown;
	}

	public void setHasCountdown(boolean hasCountdown)
	{
		this.hasCountdown = hasCountdown;
	}

	public String getSampleSet()
	{
		return sampleSet;
	}

	public void setSampleSet(String sampleSet)
	{
		this.sampleSet = sampleSet;
	}

	public float getStackLeniency()
	{
		return stackLeniency;
	}

	public void setStackLeniency(float stackLeniency)
	{
		this.stackLeniency = stackLeniency;
	}

	public int getMode()
	{
		return mode;
	}

	public void setMode(int mode)
	{
		this.mode = mode;
	}

	public boolean isLetterboxDuringBreaks()
	{
		return isLetterboxDuringBreaks;
	}

	public void setLetterboxDuringBreaks(boolean isLetterboxDuringBreaks)
	{
		this.isLetterboxDuringBreaks = isLetterboxDuringBreaks;
	}

	public boolean isWidescreenStoryboard()
	{
		return isWidescreenStoryboard;
	}

	public void setWidescreenStoryboard(boolean isWidescreenStoryboard)
	{
		this.isWidescreenStoryboard = isWidescreenStoryboard;
	}
}
