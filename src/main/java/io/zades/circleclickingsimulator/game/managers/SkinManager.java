package io.zades.circleclickingsimulator.game.managers;

import io.zades.circleclickingsimulator.game.objects.Skin;

import java.util.ArrayList;

/**
 * Created by Darren on 10/21/2014.
 */
public class SkinManager
{
	//The default skin
	public Skin defaultSkin;

	//The list of skins, the default skin should also be included
	public ArrayList<Skin> listOfSkins;

	public SkinManager()
	{
		this.listOfSkins = new ArrayList<Skin>();
	}
}
