package com.nutriblast;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Main frame of the game that contains all menus and levels.
 * 
 * @author Daniel Zhang
 * @version FINAL June 8, 2015
 */
public class GameFrame extends JFrame {
 /**
  * Main panel of the game frame. All other frames added to this panel, and
  * no other panels are added directly to the frame.
  */
 static LevelPanel levelPanel;
 static PausePanel pausePanel;
 static OutcomePanel outComePanel;
 static HighScoresPanel highScoresPanel = new HighScoresPanel();
 SplashScreenPanel splashScreen = new SplashScreenPanel();
 SwitchablePanel currentPanel;
 MainMenuPanel mainMenuPanel = new MainMenuPanel();
 OutcomePanel panel = new OutcomePanel();
 public static final int PANEL_WIDTH = (int) Toolkit.getDefaultToolkit()
   .getScreenSize().getWidth();
 public static final int PANEL_HEIGHT = (int) (1080 / (1920.0 / PANEL_WIDTH));

 public GameFrame() {
  super("Nutri-Blast");
  if (PANEL_HEIGHT == Toolkit.getDefaultToolkit().getScreenSize()
    .getHeight()) {
   this.setUndecorated(true);
  }
  this.setLayout(new BorderLayout());
  this.setCurrentPanel(mainMenuPanel);
  mainMenuPanel.setFrame(this);
  this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
  this.setLocationRelativeTo(null);
  this.setUndecorated(true);
  this.setResizable(false);
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setVisible(true);
 }

 public void setCurrentPanel(SwitchablePanel newPanel) {
  this.getContentPane().add(newPanel, BorderLayout.CENTER);
  currentPanel = newPanel;
 }

 public void switchScreenTo(SwitchablePanel newPanel) {
  this.remove(currentPanel);
  if (currentPanel != levelPanel) {
   currentPanel = null;
  }
  this.setCurrentPanel(newPanel);
  this.revalidate();
  currentPanel = newPanel;
  currentPanel.setFocusable(true);
  currentPanel.requestFocusInWindow();
  currentPanel.frame = this;
  currentPanel.repaint();
  validate();
  System.gc();
 }

 public void run() {
  BackgroundMusic bm = new BackgroundMusic();
  bm.setDaemon(true);
  bm.start();
 }
}