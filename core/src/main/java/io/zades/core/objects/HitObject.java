package io.zades.core.objects;

import java.util.List;

/**
 * Created by Darren on 10/26/2014.
 */
public class HitObject
{
	public enum HIT_OBJECT_TYPE
	{
		HIT_CIRCLE,
		HIT_SLIDER,
		HIT_SPINNER
	};

	private HIT_OBJECT_TYPE hitObjectType;

	private List<Coords> coords;
	private int time;

	public HitObject(List<Coords> coords, int time, HIT_OBJECT_TYPE type)
	{
		this.coords = coords;
		this.time = time;
		this.hitObjectType = type;
	}

	public HIT_OBJECT_TYPE getHitObjectType()
	{
		return hitObjectType;
	}

	public void setHitObjectType(HIT_OBJECT_TYPE hitObjectType)
	{
		this.hitObjectType = hitObjectType;
	}

	public List<Coords> getCoords()
	{
		return coords;
	}

	public void setCoords(List<Coords> coords)
	{
		this.coords = coords;
	}

	public int getTime()
	{
		return time;
	}

	public void setTime(int time)
	{
		this.time = time;
	}
}
