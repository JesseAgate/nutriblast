package com.nutriblast;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class PausePanel extends MenuPanel {
	
	private BufferedImage background;
	private JButton resumeButton, mainMenuButton, helpButton;
	private RescaleOp op;
	
	public PausePanel(BufferedImage background) {
		this.background = background;
		op = new RescaleOp(.3f,0,null);
		this.setLayout(null);
		resumeButton = new JButton(new ImageIcon(ImageData.getImage(ImageData.RESUMEBUTTON)));
		mainMenuButton = new JButton(new ImageIcon(ImageData.getImage(ImageData.MAINMENU_BUTTON)));
		helpButton = new JButton(new ImageIcon(ImageData.getImage(ImageData.HELPBUTTON)));
		resumeButton.setBounds((int)(GameFrame.PANEL_WIDTH/5.333), (int)(GameFrame.PANEL_HEIGHT/2.037), (int)(GameFrame.PANEL_WIDTH/9.143), (int)(GameFrame.PANEL_HEIGHT/7.714));
		helpButton.setBounds((int)(GameFrame.PANEL_WIDTH/2.24), (int)(GameFrame.PANEL_HEIGHT/2.037), (int)(GameFrame.PANEL_WIDTH/9.143), (int)(GameFrame.PANEL_HEIGHT/7.714));
		mainMenuButton.setBounds((int)(GameFrame.PANEL_WIDTH/1.419), (int)(GameFrame.PANEL_HEIGHT/2.037), (int)(GameFrame.PANEL_WIDTH/9.143), (int)(GameFrame.PANEL_HEIGHT/7.714));
		resumeButton.setActionCommand("RESUME");
		mainMenuButton.setActionCommand("MAIN MENU");
		helpButton.setActionCommand("HELP");
		resumeButton.addActionListener(this);
		mainMenuButton.addActionListener(this);
		helpButton.addActionListener(this);
		this.add(resumeButton);
		this.add(mainMenuButton);
		this.add(helpButton);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(background, op, 0, 0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("RESUME")) {
			System.out.println(GameFrame.levelPanel);
			GameFrame.levelPanel.run();
			frame.switchScreenTo(GameFrame.levelPanel);
		}
		if (e.getActionCommand().equals("HELP")) {
			frame.switchScreenTo(new HelpPanel(true));
		}
		if (e.getActionCommand().equals("MAIN MENU")) {
			frame.switchScreenTo(new MainMenuPanel());
		}
	}
}
