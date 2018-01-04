package com.nutriblast;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A ImageIcon that has an xCord and yCord. Contains all the necessary methods and attributes to make other sprites with additional attributes and behaviors.
 * 
 * <p>
 * Time Spent: 30 Minutes.
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created class
 * </p>
 * 
 * @author Jesse Agate
 * @version Final 5/16/2015
 *
 */
public class Sprite extends ImageIcon {
	/**
	 * The X-Coordinate and Y-Coordinate of the sprite
	 */
	private int xCord, yCord;

	/**
	 * Constructor creates a new sprite with an XCord, YCord and an Image.
	 * @param xCord X-Coordinate of the sprite.
	 * @param yCord Y-Coordinate of the sprite.
	 * @param image Image of the sprite.
	 */
	public Sprite(int xCord, int yCord, Image image) {
		super(image);
		this.xCord = xCord;
		this.yCord = yCord;
	}
	/**
	 * Accessor for xCord
	 * @return Returns the X-Coordinate of the sprite.
	 */
	public int getXCord() {
		return xCord;
	}
	/**
	 * Mutator for xCord 
	 * @param xCord The new value for the X-Coordinate.
	 */
	public void setXCord(int xCord) {
		this.xCord = xCord;
	}
	/**
	 * Accessor for yCord
	 * @return Returns the Y-Coordinate of the sprite.
	 */
	public int getYCord() {
		return yCord;
	}
	/**
	 * Mutator for yCord
	 * @param yCord The new Y-Coordinate for the sprite.
	 */
	public void setYCord(int yCord) {
		this.yCord = yCord;
	}

}
