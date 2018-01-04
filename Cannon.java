package com.nutriblast;
/**
 * 
 * Creates a cannon used to fire enzymes at the different molecules.
 * 
 * <p>
 * Time Spent: 45 Minutes
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created the class
 * </p>
 * 
 * @author Jesse
 * @version Final 5/17/2015
 */
public class Cannon extends Sprite {
	/**
	 * Holds the X Coordinate of the cannons head. Used for firing
	 * enzymes.
	 */
	private int cannonHeadX; 
	/**
	 * Holds the Y Coordinate of the cannons head. Used for firing
	 * enzymes.
	 */
	private int cannonHeadY;
	/**
	 * Holds the angle of the cannon in radians. Used for firing molecules.
	 */
	private double angle;

	/**
	 * Constructor for the cannon. Assigns the cannon an xCord, a yCord and an
	 * angle. The cannon's image is the same every time so an argument for the
	 * image is not passed.
	 * @param xCord X-Coordinate of the Cannon.
	 * @param yCord Y-Coordinate of the Cannon.
	 * @param angle Starting angle of the cannon.
	 */
	public Cannon(int xCord, int yCord, double angle) {
		super(xCord, yCord, ImageData.getImage(ImageData.CANNON));
		this.angle = angle;
		this.setCannonHeadY(yCord);
		this.setCannonHeadX(xCord
				+ ImageData.getImage(ImageData.CANNON).getWidth(null));
	}

	/**
	 * Accessor for angle
	 * 
	 * @return Returns the angle of the cannons rotation.
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Mutator for angle
	 * 
	 * @param angle
	 *            The new angle of rotation for the cannon.
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Accessor for cannonHeadX
	 * 
	 * @return Returns the X-Coordinate of the cannon head.
	 */
	public int getCannonHeadX() {
		return cannonHeadX;
	}

	/**
	 * Mutator for cannonHeadX
	 * 
	 * @param cannonHeadX
	 *            The new value for the X-Coordinate of the cannon head.
	 */

	public void setCannonHeadX(int cannonHeadX) {
		this.cannonHeadX = cannonHeadX;
	}

	/**
	 * Accessor for cannonHeadY
	 * 
	 * @return Returns the Y-Coordinate of the cannon head.
	 */
	public int getCannonHeadY() {
		return cannonHeadY;
	}

	/**
	 * Mutator
	 * 
	 * @param cannonHeadY
	 *            The new value for the Y-Coordinate of the cannon head.
	 */
	public void setCannonHeadY(int cannonHeadY) {
		this.cannonHeadY = cannonHeadY;
	}

}
