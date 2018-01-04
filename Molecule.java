package com.nutriblast;
import java.awt.Image;
import java.util.ArrayList;

/**
 * A moving Object that has a name used to identify the type of molecule it is.
 * 
 * <p>
 * Time Spent: 10 minutes
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * -Created Class
 * </p>
 * @author Jesse
 * @version Final 27/05/2015
 *
 */
public class Molecule extends MovingObject {
	/**
	 * The name of the molecule
	 */
	private String name;

	/**
	 * Creates a molecule which is a Moving Object with a name.
	 * 
	 * @param xCord
	 *            X-Coordinate of the Molecule
	 * @param yCord
	 *            Y-Coordinate of the Molecule.
	 * @param xVelocity
	 *            X-Velocity of the Molecule.
	 * @param yVelocity
	 *            Y-Velocity of the Molecule.
	 * @param name
	 *            The name of the Molecule.
	 * @param image
	 *            The image of the Molecule.
	 */
	public Molecule(int xCord, int yCord, int xVelocity, int yVelocity,
			String name, Image image) {
		super(xCord, yCord, xVelocity, yVelocity, image);
		this.name = name;
	}
	public boolean nameEquals (ArrayList <String> names)
	{
		for (int i = 0; i< names.size(); i ++)
		{
			if (names.get(i).equals (name))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Accessor for name
	 * 
	 * @return name The name of the Molecule.
	 */
	public String getName() {
		return name;
	}

}
