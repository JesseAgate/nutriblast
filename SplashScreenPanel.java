package com.nutriblast;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class to make splash screen.
 * <p>
 * Time Spent : 1 Hour and 30 Minutes.
 * </p>
 * <p>
 * <b> Version 1 </b> <br>
 * - Created Class
 * </p>
 * 
 * @author Jesse
 * @version Final 27/05/2015
 */
public class SplashScreenPanel extends GamePanel {
 /**
  * Two MovingObjects that will be used in the animation.
  */
 private MovingObject molecule, ammo;
 /**
  * Counter used to time the animations.
  */
 private int counter;

 /**
  * Constructor for the SplashScreen.Creates and displays the splash screen
  * on the panel.
  */
 public SplashScreenPanel() {
  cannon = new Cannon((GameFrame.PANEL_WIDTH / 2),
    (int) (GameFrame.PANEL_HEIGHT / 1.2), Math.PI * (4 / 3));
 }

 /**
  * <p>
  * Overridden for custom drawing.
  * </p>
  * <p>
  * <b>Internal Structures </b> <br>
  * If the animation counter is less then 540, the ammo and molecule will be
  * moved, given that they have already been created. Once the ammo hits the
  * molecule (i {@literal>} 540), the screen will turn white and then fade to
  * black.
  * </p>
  */
 @Override
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D) g;
  setAntialiasing(g2);
    
  if (counter < 540) {
   if (ammo != null) {
    ammo.move();
    g2.drawImage(ammo.getImage(), ammo.getXCord(), ammo.getYCord(),
      null);
    
   }
   if (molecule != null) {
    molecule.move();
    g2.drawImage(molecule.getImage(), molecule.getXCord(),
      molecule.getYCord(), null);
   }
   drawCannon(g2);
  } else {
   g2.setColor(new Color(794 - counter, 794 - counter, 794 - counter));
   g2.fillRect(0, 0, GameFrame.PANEL_WIDTH, GameFrame.PANEL_HEIGHT);
  }
 }

 /**
  * <p>
  * Will start the SplashScreenPanel's animation.
  * </p>
  * <p>
  * <b>Internal Structure </b> <br>
  * The counter is incremented with each iteration of the while loop. If the
  * counter is less then 530, it will update the cannons angle. If the
  * counter equals 10, it will create the molecule and if the counter = 450
  * it will create the ammo. At the end of each iteration, the screen is
  * redrawn.
  * </p>
  */
 public void animate() {
  while (counter < 794) {

   if (counter < 530) {
    cannon.setAngle(cannon.getAngle() + .003);
   }
   if (counter == 10) {
    molecule = new MovingObject(0, GameFrame.PANEL_HEIGHT / 4, 2,
      0, ImageData.getImage(ImageData.CARB));
   } else if (counter == 450) {
    ammo = new MovingObject(GameFrame.PANEL_WIDTH / 2,
      (int) (GameFrame.PANEL_HEIGHT / 1.5), 9,
      cannon.getAngle(), ImageData.getImage(ImageData.AMMO));
   }
   System.out.println("cool");
   repaint();
   try {
    Thread.sleep(10);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
   counter++;
  }
  frame.switchScreenTo (new MainMenuPanel());
 }
}
