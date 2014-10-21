package io.zades.circleclickingsimulator.game.loaders;

import io.zades.circleclickingsimulator.game.objects.Skin;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

import java.io.File;
import java.io.IOException;

/**
 * This loader that loads skin files
 * Created by Darren on 10/20/2014.
 */
public class SkinLoader
{
	public static final String DEFAULT_SKIN_PATH = "res/default-skin/";

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
	public Skin loadDefaultSkin()
	{
		return this.loadSkin(DEFAULT_SKIN_PATH);
	}

	public Skin loadSkin(String location)
	{
		return null;
	}

	/**
	 * Loads a skin given its directory
	 * @param skinDirectoryPath
	 */
	public void loadAllSkisn(String skinDirectoryPath)
	{

	}

	private void readSkinIni(String location, Skin skin)
	{
		//TODO: finish parsing skins inis
	}

	/**
	 * Loads all textures (images) of a skin into the skin
	 * @param location Location of the files
	 * @param skin The skin for which the files are to be loaded
	 */
	private void loadSkinTextures(String location, Skin skin)
	{
		for(String textureName: Skin.LIST_OF_TEXTURES)
		{
			Texture tempTexture = null;

			try
			{
				tempTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(location + textureName));
				skin.getTextureList().put(textureName, tempTexture);

			} catch (IOException e)
			{
				Log.warn("Cannot load skin file \"" + textureName + "\" from \"" + location + "\", falling back onto default files", e);
				e.printStackTrace();

				try
				{
					tempTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(DEFAULT_SKIN_PATH + textureName));
				} catch (IOException e1)
				{
					Log.error("Error loading default skin file \"" + textureName + "\" from \"" + location + "\", congratulations you somehow managed to break the game", e);
					e1.printStackTrace();
				}
			}

			skin.getTextureList().put(textureName, tempTexture);
		}
	}

	private void loadSkinSounds(String location, Skin skin)
	{

	}
}
