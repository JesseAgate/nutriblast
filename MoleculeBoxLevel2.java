package com.nutriblast;
/**
 * Holds an array of molecules.
 * 
 * <p>
 * Time Spent: 2 hours.
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created the class <br>
 * <b>Version 2</b> <br>
 * - Implemented updatePath
 * </p>
 * 
 * @author Jesse
 * @version Final 6/06/2015
 *
 */
public class MoleculeBoxLevel2 extends MovingObjectBox {

	/**
	 * <p>
	 * Updates the path of every molecule in itemList.
	 * </p>
	 * <p>
	 * <b>Local Variables</b> <br>
	 * <i>i</i> - A MovingObject used to iterate through every MovingObject in
	 * itemList through a for-each loop.
	 * </p>
	 * <p>
	 * <b>Internal Structures</b> <br>
	 * A for each loop iterates through each molecule. If a moving object has
	 * reached a position where it needs to change its path, the x o y
	 * velocity of that object is changed. A series of if statements are used to determine
	 * when the molecule needs to change their path.
	 * </p>
	 */
	@Override
	public void updatePath() {
		for (MovingObject i : itemList) {
			if (i.getYCord() > GameFrame.PANEL_HEIGHT / 7.7142
					&& i.getYCord() < GameFrame.PANEL_HEIGHT / 7.7142 + 10) {
				i.setYVelocity(2);
				i.setXVelocity(1);
			}
			if ((i.getXCord() > GameFrame.PANEL_WIDTH / 1.768
					&& i.getXCord() < GameFrame.PANEL_WIDTH / 1.768 + 10)) {
				i.setYVelocity(-2);
			}
			if (i.getXCord() > GameFrame.PANEL_WIDTH / 1.563
					&& i.getXCord() < GameFrame.PANEL_WIDTH / 1.563 + 10 || (i.getYCord() < GameFrame.PANEL_HEIGHT / 1.6
					&& (i.getXCord() > GameFrame.PANEL_WIDTH / 2.2857 && i
							.getXCord() < GameFrame.PANEL_WIDTH / 2.2857 + 10))) 
			{
				i.setYVelocity(2);
			}
			if (i.getXCord() > GameFrame.PANEL_WIDTH / 1.344
					&& i.getXCord() < GameFrame.PANEL_WIDTH / 1.344 + 10 || (i.getYCord() < GameFrame.PANEL_HEIGHT/1.8 &&  i.getXCord() < GameFrame.PANEL_WIDTH / 3.027)) {
				i.setXVelocity(-2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT / 1.16
					&& i.getXCord() < GameFrame.PANEL_WIDTH / 3.027) {
				i.setXVelocity(0);
				i.setYVelocity(-2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/2.204 && i.getXCord() < GameFrame.PANEL_WIDTH/3.9184)
			{
				i.setYVelocity (0);
			}
			if (i.getXCord() < GameFrame.PANEL_WIDTH/4.95)
			{
				i.setYVelocity(1);
			}
			if (i.getXCord() < GameFrame.PANEL_WIDTH/7.5)
			{
				i.setXVelocity (0);
				i.setYVelocity (7);
			}
		}
	}
}
