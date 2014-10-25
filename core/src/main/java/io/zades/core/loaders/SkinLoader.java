package io.zades.core.loaders;

import com.badlogic.gdx.Gdx;
import io.zades.core.objects.CCSSkin;
/**
 * This loader that loads skin files.
 * Created by Darren on 10/20/2014.
 */
public final class SkinLoader
{
	public static final String DEFAULT_SKIN_PATH = "res/default-skin/";

	private SkinLoader()
	{
	}

	/**
	 * Loads the default skin
	 *
	 * @return The loaded default skin
	 */
	public static CCSSkin loadDefaultSkin()
	{
		return SkinLoader.loadSkin(DEFAULT_SKIN_PATH);
	}

	/**
	 * Loads a skin given its directory
	 *
	 * @param location The directory of the skin
	 * @return The loaded skin
	 */
	public static CCSSkin loadSkin(String location)
	{
		CCSSkin CCSSkinToLoad = new CCSSkin();
		SkinLoader.loadSkinTextures(location, CCSSkinToLoad);

		return CCSSkinToLoad;
	}

	/**
	 * Loads a skin given its directory
	 * @param skinDirectoryPath
	 */
	public static void loadAllSkisn(String skinDirectoryPath)
	{
		//TODO: maybe write this method or just delete it and let the manager handle individual skin loading
	}

	private static void readSkinIni(String location, CCSSkin CCSSkin)
	{
		//TODO: finish parsing skins inits
	}

	/**
	 * Loads all textures (images) of a skin into the skin.
	 * This will try to load a file from the folder, if the file does not exist,
	 * it will try to load the default skin version of the file, if that doesn't
	 * exist then whoever is running the program fucked something up
	 *
	 * @param location Location of the files
	 * @param CCSSkin The skin for which the files are to be loaded
	 */
	private static void loadSkinTextures(String location, CCSSkin CCSSkin)
	{

		for(String textureName: CCSSkin.LIST_OF_TEXTURES)
		{

			try
			{
				//TODO: create static final string for the tag for SkinLoader
				Gdx.app.debug("SkinLoader", "Adding skin file \"" + textureName + "\" from \"" + location + "\" to queue");

			} catch (Exception e)
			{
				Gdx.app.log("SkinLoader", "WARNING: Cannot add skin file \"" + textureName + "\" from \"" + location + "\" to queue, falling back onto default files", e);
				e.printStackTrace();

				try
				{
					Gdx.app.debug("SkinLoader", "Adding skin file \"" + textureName + "\" from \"" + DEFAULT_SKIN_PATH + "\" to queue");

				} catch (Exception e1)
				{
					Gdx.app.error("SkinLoader", "Error loading default skin file \"" + textureName + "\" from \"" + location + "\", did you move the skin files?", e);
					System.exit(-1);
				}
			}

		}
	}

	private static void loadSkinSounds(String location, CCSSkin CCSSkin)
	{
		//TODO: finish loading in sounds
	}
}
