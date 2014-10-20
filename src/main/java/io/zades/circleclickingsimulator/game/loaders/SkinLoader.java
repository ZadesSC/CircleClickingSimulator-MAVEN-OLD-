package io.zades.circleclickingsimulator.game.loaders;

import java.io.File;

/**
 * This loader that loads skin files
 * Created by Darren on 10/20/2014.
 */
public class SkinLoader
{
	private File skinBaseDirectory;
	/**
	 * Loads all skins from a a non-default skins directory
	 * @param skinBaseDirectoryPath
	 */
	public SkinLoader(String skinBaseDirectoryPath)
	{
		this.skinBaseDirectory = new File(skinBaseDirectoryPath);
	}

	/**
	 * Loads all skins from the default directory
	 */
	public SkinLoader()
	{

	}

	/**
	 * Loads the default skin
	 */
	private void loadDefaultSkin()
	{

	}

	/**
	 * Loads a skin given its directory
	 * @param skinDirectoryPath
	 */
	private void loadSkin(String skinDirectoryPath)
	{

	}
}
