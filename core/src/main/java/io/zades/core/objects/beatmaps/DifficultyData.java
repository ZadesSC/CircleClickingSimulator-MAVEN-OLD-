package io.zades.core.objects.beatmaps;

/**
 * Model for the difficulty data for beatmaps
 * Created by Darren on 10/29/2014.
 */
public class DifficultyData
{
	private int lifeDrain;
	private float circleSize;
	private int overallDifficulty;
	private int approachRate;
	private float sliderMultiplier;
	private float sliderTickRate;

	public DifficultyData()
	{
		this.setLifeDrain(5);
		this.setCircleSize(5);
		this.setOverallDifficulty(5);
		this.setApproachRate(5);
		this.setSliderMultiplier(1);
		this.setSliderTickRate(1);
	}

	public int getLifeDrain()
	{
		return lifeDrain;
	}

	public void setLifeDrain(int lifeDrain)
	{
		this.lifeDrain = lifeDrain;
	}

	public float getCircleSize()
	{
		return circleSize;
	}

	public void setCircleSize(float circleSize)
	{
		this.circleSize = circleSize;
	}

	public int getOverallDifficulty()
	{
		return overallDifficulty;
	}

	public void setOverallDifficulty(int overallDifficulty)
	{
		this.overallDifficulty = overallDifficulty;
	}

	public int getApproachRate()
	{
		return approachRate;
	}

	public void setApproachRate(int approachRate)
	{
		this.approachRate = approachRate;
	}

	public float getSliderMultiplier()
	{
		return sliderMultiplier;
	}

	public void setSliderMultiplier(float sliderMultiplier)
	{
		this.sliderMultiplier = sliderMultiplier;
	}

	public float getSliderTickRate()
	{
		return sliderTickRate;
	}

	public void setSliderTickRate(float sliderTickRate)
	{
		this.sliderTickRate = sliderTickRate;
	}
}
