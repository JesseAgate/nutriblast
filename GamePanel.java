package com.nutriblast;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

/**
 * Class contains attributes and fields necessary for LevelPanel and
 * SplashScreenPanel.
 * <p>
 * Time Spent: 30 Minutes
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created class
 * 
 * @author Jesse
 * @version Final 5/27/2015
 */
public class GamePanel extends SwitchablePanel {
	/**
	 * Cannon object used in both the LevelPanel and the Splash Screen.
	 */
	Cannon cannon;
	/**
	 * Draws a cannon on the screen.
	 * 
	 * @param g2 The Graphics2D object that is being used to draw the cannon.
	 */
	public void drawCannon(Graphics2D g2) {
		g2.rotate(cannon.getAngle(), cannon.getXCord(), cannon.getYCord()
				+ cannon.getImage().getHeight(null) / 2);
		g2.drawImage(cannon.getImage(), cannon.getXCord(), cannon.getYCord(),
				null);
	}

	/**
	 * Overridden to allow for double buffering.
	 */
	@Override
	public void paint(Graphics g) {
		Image bufferImage = createImage(GameFrame.PANEL_WIDTH,
				GameFrame.PANEL_HEIGHT);
		Graphics bufferGraphics = bufferImage.getGraphics();
		paintComponent(bufferGraphics);
		g.drawImage(bufferImage, 0, 0, this);
	}
}
