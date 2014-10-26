package io.zades.core.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import io.zades.core.CCSCore;
import io.zades.core.managers.CCSSkinManager;
import io.zades.core.objects.CCSSkin;
/**
 * This loader that loads skin files.
 * Created by Darren on 10/20/2014.
 */
public final class CCSSkinLoader
{
	private CCSSkinLoader()
	{
	}

	/**
	 * TODO: This method is currently here just in case, if this is not used deleted this
	 * @param skin
	 * @param game
	 * @return
	 */
	public static CCSSkin loadDefaultSkin(CCSSkin skin, CCSCore game)
	{
		CCSSkinLoader.loadSkinTextures(skin, game.assetManager);
		return skin;
	}

	/**
	 * Loads a skin given its directory
	 *
	 * @param skin The skin to be loaded
	 * @param game The current game instance
	 * @return The loaded skin
	 */
	public static CCSSkin loadSkin(CCSSkin skin, CCSCore game)
	{
		if(skin.getLocation() == null || skin.getLocation().equals(""))
		{
			Gdx.app.error(CCSSkinLoader.class.toString(), "Attempting to load a skin without an associated path");
			return null;
		}
		CCSSkinLoader.loadSkinTextures(skin, game.assetManager);
		return skin;
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
	 * @param skin The skin for which the files are to be loaded
	 * @param am The AssetManager used for loading
	 */
	private static void loadSkinTextures(CCSSkin skin, AssetManager am)
	{
		String location = skin.getLocation();

		for(String textureName: CCSSkin.LIST_OF_TEXTURES)
		{
			try
			{
				Gdx.app.debug(CCSSkinLoader.class.toString(), "Adding skin file \"" + textureName + "\" from \"" + location + "\" to queue");
				am.load(location + textureName, Texture.class);

			} catch (Exception e)
			{
				Gdx.app.error(CCSSkinLoader.class.toString(), "WARNING: Cannot add skin file \"" + textureName + "\" from \"" + location + "\" to queue, falling back onto default files", e);
				//e.printStackTrace();

				try
				{
					Gdx.app.debug(CCSSkinLoader.class.toString(), "Adding skin file \"" + textureName + "\" from \"" + CCSSkinManager.DEFAULT_SKIN_PATH + "\" to queue");
					am.load(CCSSkinManager.DEFAULT_SKIN_PATH + textureName, Texture.class);
				} catch (Exception e1)
				{
					Gdx.app.error(CCSSkinLoader.class.toString(), "Error loading default skin file \"" + textureName + "\" from \"" + location + "\", did you move the skin files or changed the name?", e);
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
