package io.zades.core.managers;

import io.zades.core.CCSCore;
import io.zades.core.loaders.CCSSkinLoader;
import io.zades.core.objects.CCSSkin;

import java.util.HashMap;

/**
 * Created by Darren on 10/21/2014.
 */
public class CCSSkinManager
{
	public static final String DEFAULT_SKIN_PATH = "data/default-skin/";
	public static final String SKIN_PATH = "Skins/";

	private CCSCore game;
	private CCSSkin currentCCSSkin;
	private CCSSkin defaultCCSSkin;

	//The list of skins by their directory, which should be unique
	private HashMap<String, CCSSkin> listOfSkinsByDirectory;

	public CCSSkinManager(CCSCore game)
	{
		this.game = game;
		this.setListOfSkinsByDirectory(new HashMap<String, CCSSkin>());

	}

	public void initAllSkins()
	{
		this.initDefaultSkin();
		this.setCurrentCCSSkin(getDefaultCCSSkin());
		//TODO: init other skins
	}

	private CCSSkin initDefaultSkin()
	{
		CCSSkin defaultSkin = new CCSSkin(DEFAULT_SKIN_PATH);
		CCSSkinLoader.loadSkin(defaultSkin, this.game);

		this.setDefaultCCSSkin(defaultSkin);
		this.getListOfSkinsByDirectory().put(defaultSkin.getLocation(), defaultSkin);

		return defaultSkin;
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

	public HashMap<String, CCSSkin> getListOfSkinsByDirectory()
	{
		return listOfSkinsByDirectory;
	}

	public void setListOfSkinsByDirectory(HashMap<String, CCSSkin> listOfSkinsByDirectory)
	{
		this.listOfSkinsByDirectory = listOfSkinsByDirectory;
	}
}
