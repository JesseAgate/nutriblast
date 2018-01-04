package com.nutriblast;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * 
 * Time Spent: 1 hour
 * 
 * @author Daniel Zhang
 * @version FINAL June 8, 2015
 *
 */
public class OutcomePanel extends MenuPanel {

	private JButton continueButton, mainMenuButton, submitButton;

	private JTextField field;

	public OutcomePanel() {

		try { // MOVE TO SUPER
			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(
					fontPath + "Champagne & Limousines.ttf")));
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		continueButton = new JButton(new ImageIcon(
				ImageData.getImage(ImageData.CONTINUE_BUTTON)));
		mainMenuButton = new JButton(new ImageIcon(
				ImageData.getImage(ImageData.MAINMENU_BUTTON)));
		continueButton.setBounds((int) (GameFrame.PANEL_WIDTH / 38.4),
				(int) (GameFrame.PANEL_HEIGHT / 1.2),
				(int) (GameFrame.PANEL_WIDTH / 9.143),
				(int) (GameFrame.PANEL_HEIGHT / 7.714));
		mainMenuButton.setBounds((int) (GameFrame.PANEL_WIDTH / 1.156),
				(int) (GameFrame.PANEL_HEIGHT / 1.2),
				(int) (GameFrame.PANEL_WIDTH / 9.143),
				(int) (GameFrame.PANEL_HEIGHT / 7.714));
		continueButton.addActionListener(this);
		mainMenuButton.addActionListener(this);
		continueButton.setActionCommand("CONTINUE");
		mainMenuButton.setActionCommand("MAIN MENU");
		submitButton = new JButton("Submit");
		submitButton.setBounds(400, 400, 100, 100);
		submitButton.addActionListener(this);
		this.add(continueButton);
		this.add(mainMenuButton);
		field = new JTextField("", 20);
		field.addActionListener(this);
		this.add(field);
		this.add(submitButton);
		field.setBounds(700, 700, 100, 20);
	}

	String winMessage = "Congratulations, you have beaten ";
	String loseMessage = "Unfortunately, you were unsuccessful in surviving ";
	String loseMessage2 = "Don't fret, just try the level again!";

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(ImageData.getImage(ImageData.OUTCOME_BACKGROUND), 0, 0,
				null);
		setAntialiasing(g2);
		g.setColor(Color.white);
		// g.setFont(new Font("Champagne & Limousines", Font.PLAIN, (int) (g
		// .getFont().getSize() * 3.5F)));
		// g.drawString(winMessage + "Level 1 of NutriBlast!", 382, 650);
		g.setFont(new Font("Champagne & Limousines", Font.PLAIN, (int) (g
				.getFont().getSize() * 3.4F)));
		g.drawString(loseMessage + "Level 1 of NutriBlast.", 290, 650);
		g.drawString(loseMessage2, 640, 710);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CONTINUE")) {
		}
		if (e.getActionCommand().equals("MAIN MENU")) {
			frame.switchScreenTo(new MainMenuPanel());
		}
		if (e.getActionCommand().equals("Submit")) {
			if (!field.getText().equals("") && field.getText().length() < 21) {
				GameFrame.highScoresPanel.passNewScore(
						new HighScore(field.getText(), "1:50"),
						GameFrame.levelPanel.getLevel());

				// GameFrame.highScoresPanel.passNewScore (new
				// HighScore(field.getText(),
				// (GameFrame.levelPanel.timer.getLevelTime())));

			}

		}
	}
}
