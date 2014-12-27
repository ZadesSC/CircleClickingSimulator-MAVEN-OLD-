package io.zades.core.objects;

import com.badlogic.gdx.Gdx;

/**
 * Created by Darren on 10/26/2014.
 */
public class Coords
{
	public enum CoordType {GAME, LIBGDX};
	private double x;
	private double y;

	public Coords(double x, double y, CoordType type)
	{
		switch (type)
		{
			case GAME:
				this.setX(x);
				this.setY(y);
				break;
			case LIBGDX:

				break;
		}
	}

	private double getRatio()
	{
		//we check to ratio to know what to scale with, 0.75 is the scale of the game internals (384/512)
		//if the screen ratio is smaller than 0.75 we match the height, if it's larger we match the width
		if(Gdx.app.getGraphics().getHeight()/Gdx.app.getGraphics().getWidth() > 0.75)
		{
			return 512.0 / Gdx.app.getGraphics().getWidth();
		}
		else
		{
			return 384.0 / Gdx.app.getGraphics().getHeight();
		}
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public void setGdxX(double x)
	{
		//convert gdx units into internal units
		this.x = x * this.getRatio();
	}

	public double getGdxX()
	{
		return this.x / this.getRatio();
	}

	public void setGdxY(double y)
	{
		this.y = 384 - y * this.getRatio();
	}

	public double getGdxY()
	{
		return Gdx.app.getGraphics().getHeight() - this.y / this.getRatio();

	}
}
