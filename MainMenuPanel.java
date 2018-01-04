package com.nutriblast;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Timer;

public class MainMenuPanel extends MenuPanel {

 Ellipse2D.Double playCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/9.552, GameFrame.PANEL_HEIGHT/14.795, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
 Ellipse2D.Double highScoresCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/37.647, GameFrame.PANEL_HEIGHT/3.401, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
 Ellipse2D.Double helpCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/3.824, GameFrame.PANEL_HEIGHT/2.236, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
 Ellipse2D.Double optionsCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/5.47, GameFrame.PANEL_HEIGHT/1.489, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
 Ellipse2D.Double exitCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/1.208, GameFrame.PANEL_HEIGHT/1.469, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);

 Point p = new Point();
 private boolean insidePlayCircle = false;
 private boolean insideScoresCircle = false;
 private boolean insideHelpCircle = false;
 private boolean insideOptionsCircle = false;
 private boolean insideExitCircle = false;
 private boolean clicked = false;

 public MainMenuPanel() {
  this.setLayout(null);
  this.addMouseListener(this);
  this.addMouseMotionListener(this);
  this.setFocusable(true);
  this.requestFocusInWindow();
 }

 @Override
 public void mouseMoved(MouseEvent e) {
  Point point = e.getPoint();
  if (playCircle.contains(point)) {
   insidePlayCircle = true;
  } else {
   insidePlayCircle = false;
  }
  if (helpCircle.contains(point)) {
   insideHelpCircle = true;
  } else {
   insideHelpCircle = false;
  }
  if (exitCircle.contains(point)) {
   insideExitCircle = true;
  } else {
   insideExitCircle = false;
  }
  if (optionsCircle.contains(point)) {
   insideOptionsCircle = true;
  } else {
   insideOptionsCircle = false;
  }
  if (highScoresCircle.contains(point)) {
   insideScoresCircle = true;
  } else {
   insideScoresCircle = false;
  }
  p = point;
  repaint();
 }

 @Override
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.drawImage(ImageData.getImage(ImageData.MAIN_MENU_BACKGROUND), 0, 0, null);
  g.setColor(Color.white);
  //play button
  if (insidePlayCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int) (PANEL_WIDTH / 15.36), (int) (PANEL_HEIGHT / 29.19), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.PLAYBUTTON_CLICKED), (int) (PANEL_WIDTH / 15.36), (int) (PANEL_HEIGHT / 29.19), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.PLAYBUTTON_UNCLICKED), (int) (PANEL_WIDTH / 15.36), (int) (PANEL_HEIGHT / 29.19),null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.PLAYBUTTON_UNCLICKED), (int) (PANEL_WIDTH / 15.36), (int) (PANEL_HEIGHT / 29.19),null);
  }
  //help button
  if (insideHelpCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/4.528), (int)(GameFrame.PANEL_HEIGHT/2.4), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.HELPBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/4.528), (int)(GameFrame.PANEL_HEIGHT/2.4), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.HELPBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/4.528), (int)(GameFrame.PANEL_HEIGHT/2.4), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.HELPBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/4.528), (int)(GameFrame.PANEL_HEIGHT/2.4), null);
  }
  //exit button
  if (insideExitCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED),  (int)(GameFrame.PANEL_WIDTH/1.273), (int)(GameFrame.PANEL_HEIGHT/1.536), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.EXITBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/1.273), (int)(GameFrame.PANEL_HEIGHT/1.536), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.EXITBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/1.273), (int)(GameFrame.PANEL_HEIGHT/1.536), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.EXITBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/1.273), (int)(GameFrame.PANEL_HEIGHT/1.536), null);
  }
  //options button
  if (insideOptionsCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/7.137), (int)(GameFrame.PANEL_HEIGHT/1.565), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.OPTIONSBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/7.137), (int)(GameFrame.PANEL_HEIGHT/1.565), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.OPTIONSBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.137), (int)(GameFrame.PANEL_HEIGHT/1.565), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.OPTIONSBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.137), (int)(GameFrame.PANEL_HEIGHT/1.565), null);
  }
  //scores button
  if (insideScoresCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/-45.7), (int)(GameFrame.PANEL_HEIGHT/3.971), null);
   if (clicked) {
    //animateTransition(g);
    g.drawImage(ImageData.getImage(ImageData.HIGHSCORESBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/-45.7), (int)(GameFrame.PANEL_HEIGHT/3.971), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.HIGHSCORESBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/-45.7), (int)(GameFrame.PANEL_HEIGHT/3.971), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.HIGHSCORESBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/-45.7), (int)(GameFrame.PANEL_HEIGHT/3.971), null);
  }
 }

 
 @Override
 public void mouseClicked(MouseEvent e) {
  if (e.getButton() == MouseEvent.BUTTON1) {
   if (insideScoresCircle) {
    frame.switchScreenTo(new HighScoresPanel());
   } else if (insideOptionsCircle) {
    frame.switchScreenTo(new OptionsPanel());
   } else if (insideHelpCircle) {
    frame.switchScreenTo(new HelpPanel(false));
   } else if (insidePlayCircle) {
    frame.switchScreenTo(new LevelSelectPanel());
   } 
   else {
    if (insideExitCircle) {
     System.exit(0);
    }
   }
  }
 }

 @Override
 public void mousePressed(MouseEvent e) {
  if (e.getButton() == MouseEvent.BUTTON1) {
   clicked = true;
  }
  repaint();
 }
 
 @Override
 public void mouseReleased(MouseEvent e) {
  if (e.getButton() == MouseEvent.BUTTON1) {
         clicked = false;
     }
  repaint();
 }
}
