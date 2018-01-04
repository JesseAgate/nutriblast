package com.nutriblast;


/**
 * A sprite that has been given a path and speed. Used to create enzymes and molecules.
 * 
 * <p>
 * Time Spent 1 Hour and 30 Minutes.
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created the class <br>
 * <b>Version 2</b> <br>
 * - Created a second constructor
 * </p>
 *
 * @author Jesse
 * @version Final 5/16/2015
 *
 */
import java.awt.Image;

public class MovingObject extends Sprite{
	/**
	 * How many pixels the objects position will move in the X and Y direction every time it is animated.
	 */
  private int yVelocity,xVelocity;
  
  
  /**
   * Used to create moving sprites that are not fired from the cannon. Sprite will be given
   * an X and Y Coordinate , and an X and Y velocity.
   * @param xCord X-Coordinate of the sprite.
   * @param yCord Y-Coordinate of the sprite.
   * @param xVelocity The number of pixels the sprite will be moved in the X direction every time it is animated.
   * @param yVelocity The number of pixels the sprite will be moved in the Y direction every time it is animated.
   * @param image The image given to the sprite.
   */
  public MovingObject (int xCord, int yCord, int xVelocity, int yVelocity, Image image) {
	  super  (xCord, yCord, image);
	  this.xVelocity = xVelocity;
	  this.yVelocity = yVelocity;
  }
  
  /**
   * Constructor used to create moving sprites fired from the cannon. Gives the sprite an X and Y Coordinate as well as 
   * an X and Y Velocity calculated from the speed and angle. 
   * @param xCord X-Coordinate of the sprite.
   * @param yCord Y-Coordinate of the sprite.
   * @param speed The speed of the sprite, to be translated into an X and Y Velocity.
   * @param angle The angle at which the sprite was fired, used to calculate X and Y velocity.
   * @param image The image of the sprite.
   */
  public MovingObject (int xCord, int yCord, double speed, double angle, Image image)
  {
	super (xCord,yCord,image);
    yVelocity = (int)(speed*(Math.sin(angle)));
    xVelocity = (int)( speed*(Math.cos(angle)));
  }   
  
  /**
   * Accessor for xVelocity.
   * @return Returns this objects xVelocity.
   */
  public int getXVelocity ()
  {
	  return xVelocity;
  }
  /**
   * Accessor for yVelocity
   * @return Returns this objects yVelocity.
   */
  public int getYVelocity ()
  {
	  return yVelocity;
  }
  /**
   * Mutator for xVelocity.
   * @param xVelocity The new value for the objects xVelocity.
   */
  public void setXVelocity (int xVelocity)
  {
	  this.xVelocity = xVelocity;
  }
  /**
   * Mutator for yVelocity.
   * @param yVelocity The new value fro this objects yVelocity.
   */
  public void setYVelocity (int yVelocity)
  {
	  this.yVelocity = yVelocity;
  }
  
  /**
   * Moves the sprite along its given trajectory by incrementing its X Coordinate and Y Coordinate by
   * its respective velocity.
   */
  public void move ()
  {
    setXCord(getXCord() + xVelocity);
    setYCord (getYCord () + yVelocity);
  }


}

