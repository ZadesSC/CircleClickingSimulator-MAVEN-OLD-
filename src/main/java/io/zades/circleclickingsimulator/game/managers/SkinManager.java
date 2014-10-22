package io.zades.circleclickingsimulator.game.managers;

import io.zades.circleclickingsimulator.game.Game;
import io.zades.circleclickingsimulator.game.loaders.SkinLoader;
import io.zades.circleclickingsimulator.game.objects.Skin;
import org.newdawn.slick.state.StateBasedGame;

import java.util.HashMap;

/**
 * Created by Darren on 10/21/2014.
 */
public class SkinManager
{
	private StateBasedGame game;

	private Skin currentSkin;
	private Skin defaultSkin;

	//The list of skins, the default skin should also be included
	private HashMap<String, Skin> listOfSkins;

	public SkinManager(StateBasedGame game)
	{
		this.game = game;

		this.setListOfSkins(new HashMap<String, Skin>());

		this.initDefaultSkin();
		this.setCurrentSkin(getDefaultSkin());
	}

	private void initAllSkins()
	{

	}

	private Skin initDefaultSkin()
	{
		Skin skinToInit = SkinLoader.loadDefaultSkin();

		this.setDefaultSkin(skinToInit);
		this.getListOfSkins().put("Default Skin", skinToInit);

		return skinToInit;
	}

	private Skin initSkin()
	{
		//TODO: finish method
		//TODO: collision detection of skin names
		return null;
	}

	public Skin getCurrentSkin()
	{
		return currentSkin;
	}

	public void setCurrentSkin(Skin currentSkin)
	{
		this.currentSkin = currentSkin;
	}

	public Skin getDefaultSkin()
	{
		return defaultSkin;
	}

	public void setDefaultSkin(Skin defaultSkin)
	{
		this.defaultSkin = defaultSkin;
	}

	public HashMap<String, Skin> getListOfSkins()
	{
		return listOfSkins;
	}

	public void setListOfSkins(HashMap<String, Skin> listOfSkins)
	{
		this.listOfSkins = listOfSkins;
	}
}
