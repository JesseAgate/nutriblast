package com.nutriblast;
import java.util.ArrayList;

/**
 * 
 * This class will hold an array of moving objects and update each one of their positions. Includes an unimplemented method
 * to change the path of each object. 
 * <p>
 * Time Spent : 10 Minutes.
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created Class
 * </p>
 * @author Jesse
 * @version Final 5/19/2015
 *
 */
public abstract class MovingObjectBox {
	
	/**
	 * An array list that will hold a set of moving objects.
	 */
	ArrayList <MovingObject> itemList = new ArrayList <MovingObject> ();
		
	/**
	 * To be implement in sub classes. Updates the path of the objects in itemList.
	 */
	public abstract void updatePath ();
	
	/**
	 * Updates the position of every object in itemList.
	 */
	public void moveAlongPath ()
	{
		for (MovingObject i : itemList)
			i.move();
	}
	

}
