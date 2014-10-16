package io.zades.circleclickingsimulator.driver;

import io.zades.circleclickingsimulator.game.Game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * Hello world!
 *
 */
public class Driver
{
    public static void main( String[] args ) throws SlickException
	{
		Game ccsGame = new Game("Circle Clicking Simulator");
		AppGameContainer app = new AppGameContainer(ccsGame);

		app.setDisplayMode(800,600,false);
		app.start();

    }
}
