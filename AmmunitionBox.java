package com.nutriblast;
/**
 * Class holds an array of moving objects that will be the ammunition.
 * <p>
 * Time Spent: 20 Minutes
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created Class
 * </p>
 *
 * @author Jesse
 * @version Final 5/20/2015
 *
 */
public class AmmunitionBox extends MovingObjectBox {

	/**
	 * <p>
	 * Updates the path of the objects in itemList.
	 * </p>
	 * <p>
	 * <b>Local Variables</b>
	 * </p>
	 * <p>
	 * <i>Loop Variables </i> <br>
	 * i - Counter used in a for loop to iterate through every movingObject of
	 * itemList and update their path if need be. <br>
	 * </p>
	 * <p>
	 * <b>Internal Structures </b><br>
	 * With each iteration of the for-loop, the position of each movingObject is
	 * checked to see whether or not it has exited the screen. If it has it is
	 * removed.
	 * </p>
	 * 
	 */
	@Override
	public void updatePath() {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getXCord() > GameFrame.PANEL_WIDTH
					|| itemList.get(i).getXCord() < 1
					|| itemList.get(i).getYCord() > GameFrame.PANEL_HEIGHT
					|| itemList.get(i).getYCord() < 1) {
				itemList.remove(i);
			}
		}
	}
}
