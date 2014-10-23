package io.zades.core.loaders;

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
//		for(String textureName: Skin.LIST_OF_TEXTURES)
//		{
//			Texture tempTexture = null;
//
//			try
//			{
//				tempTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(location + textureName));
//				skin.getTextureList().put(textureName, tempTexture);
//
//				Log.debug("Adding skin file \"" + textureName + "\" from \"" + location + "\" to queue");
//
//			} catch (Exception e)
//			{
//				Log.warn("Cannot load skin file \"" + textureName + "\" from \"" + location + "\", falling back onto default files", e);
//				e.printStackTrace();
//
//				try
//				{
//					tempTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(DEFAULT_SKIN_PATH + textureName));
//
//					Log.debug("Adding skin file \"" + textureName + "\" from \"" + DEFAULT_SKIN_PATH + "\" to queue");
//
//				} catch (Exception e1)
//				{
//					Log.error("Error loading default skin file \"" + textureName + "\" from \"" + location + "\", congratulations you somehow managed to break the game", e);
//					System.exit(-1);
//					//e1.printStackTrace();
//				}
//			}
//
//			skin.getTextureList().put(textureName, tempTexture);
//		}
	}

	private static void loadSkinSounds(String location, CCSSkin CCSSkin)
	{
		//TODO: finish loading in sounds
	}
}
