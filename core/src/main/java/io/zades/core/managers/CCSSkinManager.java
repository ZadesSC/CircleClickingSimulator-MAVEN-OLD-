package io.zades.core.managers;

import io.zades.core.CCSCore;
import io.zades.core.loaders.SkinLoader;
import io.zades.core.objects.CCSSkin;

import java.util.HashMap;

/**
 * Created by Darren on 10/21/2014.
 */
public class CCSSkinManager
{
	private CCSCore game;
	private CCSSkin currentCCSSkin;
	private CCSSkin defaultCCSSkin;

	//The list of skins, the default skin should also be included
	private HashMap<String, CCSSkin> listOfSkins;

	public CCSSkinManager(CCSCore game)
	{
		this.game = game;
		this.setListOfSkins(new HashMap<String, CCSSkin>());

	}

	public void initAllSkins()
	{
		this.initDefaultSkin();
		this.setCurrentCCSSkin(getDefaultCCSSkin());
	}

	private CCSSkin initDefaultSkin()
	{
		CCSSkin CCSSkinToInit = SkinLoader.loadDefaultSkin();

		this.setDefaultCCSSkin(CCSSkinToInit);
		this.getListOfSkins().put("Default Skin", CCSSkinToInit);

		return CCSSkinToInit;
	}

	private CCSSkin initSkin()
	{
		//TODO: finish method
		//TODO: collision detection of skin names
		return null;
	}

	public CCSSkin getCurrentCCSSkin()
	{
		return currentCCSSkin;
	}

	public void setCurrentCCSSkin(CCSSkin currentCCSSkin)
	{
		this.currentCCSSkin = currentCCSSkin;
	}

	public CCSSkin getDefaultCCSSkin()
	{
		return defaultCCSSkin;
	}

	public void setDefaultCCSSkin(CCSSkin defaultCCSSkin)
	{
		this.defaultCCSSkin = defaultCCSSkin;
	}

	public HashMap<String, CCSSkin> getListOfSkins()
	{
		return listOfSkins;
	}

	public void setListOfSkins(HashMap<String, CCSSkin> listOfSkins)
	{
		this.listOfSkins = listOfSkins;
	}
}
