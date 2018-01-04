package com.nutriblast;
/**
 * Holds an array of molecules.
 * 
 * <p>
 * Time Spent: 4 hours.
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
public class MoleculeBoxLevel3 extends MovingObjectBox {

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
		for (MovingObject i : itemList) {
			if (i.getYCord() > GameFrame.PANEL_HEIGHT / 5 && i.getYCord() < GameFrame.PANEL_HEIGHT /5 +5
					&& i.getXCord() >  GameFrame.PANEL_WIDTH / 2.65 -5 && i.getXCord() < GameFrame.PANEL_WIDTH / 2.65 + 5) {
				i.setXVelocity(-2);
				i.setYVelocity(0);			}
			if ((i.getXCord() < GameFrame.PANEL_WIDTH / 3.7
					&& i.getYCord() > GameFrame.PANEL_HEIGHT / 4.97 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT / 4.97 + 5 || (i.getYCord ()> GameFrame.PANEL_HEIGHT/2.8 -5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.8 + 5 
					&& i.getXCord() > GameFrame.PANEL_WIDTH/2.55 - 5 && i.getXCord() < GameFrame.PANEL_WIDTH/2.55 + 5))) {
				i.setXVelocity(0);
				i.setYVelocity(2);
			}

			if (i.getYCord() < GameFrame.PANEL_HEIGHT / 3.5
					&& i.getYCord() > GameFrame.PANEL_HEIGHT / 3.5 - 5
					&& i.getXCord() == (int) (GameFrame.PANEL_HEIGHT/2.084)) {
				i.setXVelocity(1);
				i.setYVelocity(0);
			}
			if  (i.getYCord() < GameFrame.PANEL_HEIGHT / 3.5
					&& i.getYCord() > GameFrame.PANEL_HEIGHT / 3.5 - 5
					&& i.getXCord() > GameFrame.PANEL_WIDTH/2.84 && i.getXCord() < GameFrame.PANEL_WIDTH/2.84 +5)
					{
						i.setYVelocity (1);
					}
			if ((i.getYCord() > GameFrame.PANEL_HEIGHT/2.057 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.057 + 5
					&& i.getXCord() > GameFrame.PANEL_WIDTH/2.55 - 5 && i.getXCord() < GameFrame.PANEL_WIDTH/2.55 + 5) || i.getYCord() > GameFrame.PANEL_HEIGHT/2.769 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.769 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/2.157 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/2.157 +5 || (i.getYCord() > GameFrame.PANEL_HEIGHT/1.44 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.44 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.745 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.745 +5))
			{
				i.setXVelocity (2);
				i.setYVelocity (0);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/2.057 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.057 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/2.157 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/2.157 +5 )
			{
				i.setXVelocity (0);
				i.setYVelocity (-2);
			}
			
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/2.769 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.769 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.745 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.745 +5 )
					
			{
				i.setXVelocity(0);
				i.setYVelocity (2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/1.44 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.44 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.505 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.505 +5 )
					
			{
				i.setXVelocity(0);
				i.setYVelocity (-2);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/3.6 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/3.6 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/1.505 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/1.505 +5 )
					
			{
				i.setXVelocity(-1);
				i.setYVelocity (1);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/1.35 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.35 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/2.4774 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/2.4774 +5 )
					
			{
				i.setYVelocity (-3);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/2.16 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.16 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/2.8 -10 && i.getXCord() < GameFrame.PANEL_WIDTH/2.8 +10 )
					
			{
				i.setXVelocity (-3);
				i.setYVelocity (0);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/2.16 - 5 && i.getYCord() < GameFrame.PANEL_HEIGHT/2.16 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/3.2 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/3.2 +5 )
					
			{
				i.setXVelocity (0);
				i.setYVelocity (4);
			}
			if (i.getYCord() > GameFrame.PANEL_HEIGHT/1.317 - 50 && i.getYCord() < GameFrame.PANEL_HEIGHT/1.317 + 5 && 
					i.getXCord() > GameFrame.PANEL_WIDTH/3.2 -5 && i.getXCord() < GameFrame.PANEL_WIDTH/3.2 +5 )
					
			{
				i.setXVelocity (-4);
				i.setYVelocity (0);
			}
				
					

		}
	}
}
