package com.nutriblast;
import java.awt.Image;
/**
 * This class is used to create Gifs that will disappear after a certain amount of time.
 * <p>
 * Time Spent: 10 Minutes
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created the class
 * </p>
 * 
 * @author Jesse
 * @version Final 5/30/2015
 */

public class Gif extends Sprite 
{
	/**
	 * The time at which the Gif was created.
	 */
	private long startTime;
	/**
	 * The time for which the Gif should stay on the screen 
	 */
	private long endTime;
	/**
	 * Creates a gif. Gives it an xCord, a yCord, a start time and an end time.
	 * @param xCord The X-Coordinate of the Gif.
	 * @param yCord The Y-Coordinate of the Gif.
	 * @param image The Gif's image.
	 */
	public Gif(int xCord, int yCord, Image image) 
	{
		super(xCord, yCord, image);
		startTime = System.currentTimeMillis();
		endTime = 800;
	}
	/**
	 * This method determines whether or not the Gif should be removed from the screen.
	 * @return Returns whether or not the Gif has expired (true false)
	 */
	public boolean isExpired ()
	{
		return (System.currentTimeMillis() - startTime > endTime);
	}

}
