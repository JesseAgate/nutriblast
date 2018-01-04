package com.nutriblast;
/**
 * Holds an array of molecules.
 * 
 * <p>
 * Time Spent: 1 hour.
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
public class MoleculeBoxLevel1 extends MovingObjectBox {

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
	 * reached a position where it needs to change its path, the x o y velocity
	 * of that object is changed. A series of if statements are used to
	 * determine when the molecule needs to change their path.
	 * </p>
	 */
	@Override
	public void updatePath() {
		for (MovingObject i : itemList)
		{
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/1.44 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.44 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/3.25-5 && i.getXCord() < GameFrame.PANEL_WIDTH/3.25 +5 )
					
			{
				i.setYVelocity (-2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/5.4 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/5.4 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/3.25-5 && i.getXCord() < GameFrame.PANEL_WIDTH/3.25 +5 )
					
			{
				i.setYVelocity (1);
				i.setXVelocity (2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/2.7 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.7 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.95-5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.95 +5 )
					
			{
				i.setYVelocity (-1);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/4.408 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/4.408 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.477-5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.477 +5 )
					
			{
				i.setXVelocity (0);
				i.setYVelocity (2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/1.4 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.4 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.477-5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.477 +5 )
					
			{
				i.setXVelocity (-2);
				i.setYVelocity (0);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/1.4 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.4 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.99-5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.99 +5 )
					
			{
				i.setXVelocity (0);
				i.setYVelocity (2);
			}
		}
	}
}