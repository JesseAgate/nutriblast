package com.nutriblast;
import java.util.ArrayList;

/**
 * This class holds all gifs in an array list and controls when there are
 * removed from the array list.
 * <p>
 * <b>Time Spent: 10 Minutes </b>
 * </p>
 * <p>
 * <b>Version 1 </b><br>
 * - Created class.
 * </p>
 * 
 * @author Jesse
 * @version Final 5/28/2015
 */
public class GifBox {
	/**
	 * Holds an array of gifs.
	 */
	ArrayList<Gif> itemList = new ArrayList<Gif>();

	/**
	 * This method iterates through each gif and removes it from itemList if it
	 * has expired.
	 * <p>
	 * <b>Local Variables</b> <br>
	 * <i>i</i> - Loop variable used in a for loop to iterate through every gif of
	 * itemList and remove them if need be. <br>
	 * </p>
	 * <p>
	 * <b>Internal Structures </b><br>
	 * With each iteration of the for-loop, each gif is checked to see whether
	 * or not it has expired yet. If it has, its removed.
	 * </p>
	 * 
	 */
	public void removeExpired() {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).isExpired()) {
				itemList.remove(i);
			}
		}
	}
}
