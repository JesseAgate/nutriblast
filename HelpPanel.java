package com.nutriblast;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HelpPanel extends MenuPanel {

	/**
	 * Represents the clickable area of the "next" button.
	 */
	private Ellipse2D.Double nextCircle = new Ellipse2D.Double(
			GameFrame.PANEL_WIDTH / 54.857, GameFrame.PANEL_HEIGHT / 3.661,
			GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);

	/**
	 * Represents the clickable area of the "back" button.
	 */
	private Ellipse2D.Double backCircle = new Ellipse2D.Double((int)(GameFrame.PANEL_WIDTH/61.935), GameFrame.PANEL_HEIGHT/1.421, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
	
	/**
	 * Booleans involved in determining whether the mouse has entered an Ellipse
	 * object or has been clicked.
	 */
	private boolean insideBackCircle = false, insideNextCircle = false,
			clicked = false, paused;
	
	private int infoNumber = 1;
	
	public HelpPanel(boolean paused) {
		this.paused = paused;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (infoNumber == 1) {
			g.drawImage(ImageData.getImage(ImageData.INFO1), 0, 0, null);
		} else if (infoNumber == 2) {
			g.drawImage(ImageData.getImage(ImageData.INFO2), 0, 0, null);
		} else if (infoNumber == 3) {
			g.drawImage(ImageData.getImage(ImageData.INFO3), 0, 0, null);
		} else if (infoNumber == 4) {
			g.drawImage(ImageData.getImage(ImageData.INFO4), 0, 0, null);
		} else if (infoNumber == 5) {
			g.drawImage(ImageData.getImage(ImageData.INFO5), 0, 0, null);
		} else {
			g.drawImage(ImageData.getImage(ImageData.CONTROLS_BACKGROUND), 0, 0, null);
		}
		if (insideNextCircle) {
			g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/-60), 264, null);
			if (clicked) {
				g.drawImage(ImageData.getImage(ImageData.NEXTBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/-42.667), (int)(GameFrame.PANEL_HEIGHT/4.075), null);
			} else {
				g.drawImage(ImageData.getImage(ImageData.NEXTBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/-42.667), (int)(GameFrame.PANEL_HEIGHT/4.075), null);
			}
		} else {
			g.drawImage(ImageData.getImage(ImageData.NEXTBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/-42.667), (int)(GameFrame.PANEL_HEIGHT/4.075), null);
		}
		if (insideBackCircle) {
			g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/-54.857), (int)(GameFrame.PANEL_HEIGHT/1.455), null);
			if (clicked) {
				g.drawImage(ImageData.getImage(ImageData.BACKBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/-40), (int)(GameFrame.PANEL_HEIGHT/1.483), null);
			} else {
				g.drawImage(ImageData.getImage(ImageData.BACKBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/-40), (int)(GameFrame.PANEL_HEIGHT/1.483), null);
			}
		} else {
			g.drawImage(ImageData.getImage(ImageData.BACKBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/-40), (int)(GameFrame.PANEL_HEIGHT/1.483), null);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		Point point = e.getPoint();
		if (backCircle.contains(point)) {
			insideBackCircle = true;
		} else {
			insideBackCircle = false;
		}
		if (nextCircle.contains(point)) {
			insideNextCircle = true;
		} else {
			insideNextCircle = false;
		}
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			clicked = true;
			repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			clicked = false;
			repaint();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (insideBackCircle) {
				infoNumber--;
				if (infoNumber == 0) {
					if (paused) {
						frame.switchScreenTo(GameFrame.pausePanel);
					} else {
						frame.switchScreenTo(new MainMenuPanel());
					}
				}
			} else {
				if (insideNextCircle) {
					infoNumber++;
					if (infoNumber == 7) {
						if (paused) {
							System.out.println(frame);
							frame.switchScreenTo(GameFrame.pausePanel);
						} else {
							frame.switchScreenTo(new MainMenuPanel());
						}
					}
				}
			}
		}
	}
}
