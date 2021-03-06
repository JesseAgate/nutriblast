package com.nutriblast;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * Time Spent: 1.5 hours
 * 
 * @author Daniel Zhang
 *
 */
public class OptionsPanel extends MenuPanel {
 private JButton backButton, resetScoresButton;

 Ellipse2D.Double printCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/2.335, GameFrame.PANEL_HEIGHT/2.298, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
 Ellipse2D.Double musicCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/5.907, GameFrame.PANEL_HEIGHT/2.298, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);
 Ellipse2D.Double helpFileCircle = new Ellipse2D.Double(GameFrame.PANEL_WIDTH/1.445, GameFrame.PANEL_HEIGHT/2.298, GameFrame.PANEL_WIDTH/6.857, GameFrame.PANEL_WIDTH/6.857);

 private boolean insidePrintCircle = false, insideMusicCircle = false,
   insideFileCircle = false;

 private boolean clicked;
 private boolean musicOn = true;

 public OptionsPanel() {
  this.setLayout(null);
  backButton = new JButton(new ImageIcon(ImageData.getImage(ImageData.BACKBUTTON)));
  backButton.setBounds((int)(GameFrame.PANEL_WIDTH/2.56), (int)(GameFrame.PANEL_HEIGHT/1.271), (int)(GameFrame.PANEL_WIDTH/9.142), (int)(GameFrame.PANEL_HEIGHT/7.714));
  resetScoresButton = new JButton(new ImageIcon(ImageData.getImage(ImageData.RESETBUTTON)));
  resetScoresButton.setBounds((int)(GameFrame.PANEL_WIDTH/1.939), (int)(GameFrame.PANEL_HEIGHT/1.271), (int)(GameFrame.PANEL_WIDTH/9.142), (int)(GameFrame.PANEL_HEIGHT/7.714));
  backButton.setActionCommand("BACK");
  resetScoresButton.setActionCommand("RESET SCORES");
  this.add(backButton);
  this.add(resetScoresButton);
  backButton.addActionListener(this);
  resetScoresButton.addActionListener(this);
  this.addMouseListener(this);
  this.addMouseMotionListener(this);
 }

 @Override
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.setColor(Color.white);
  g.drawImage(ImageData.getImage(ImageData.OPTIONS_BACKGROUND), 0, 0, null);
  if (insidePrintCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/2.57), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.PRINTBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/2.57), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.PRINTBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/2.57), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.PRINTBUTTON_UNCLICKED),(int)(GameFrame.PANEL_WIDTH/2.57), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
  }
  if (insideMusicCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   if (clicked) {
    if (musicOn) {
     g.drawImage(ImageData.getImage(ImageData.MUSICONBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
    } else {
     g.drawImage(ImageData.getImage(ImageData.MUSICOFFBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
    }
   } else {
    if (musicOn) {
     g.drawImage(ImageData.getImage(ImageData.MUSICONBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
    } else {
     g.drawImage(ImageData.getImage(ImageData.MUSICOFFBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.93442), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
    }
   }
  } else {
   if (musicOn) {
    g.drawImage(ImageData.getImage(ImageData.MUSICONBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.MUSICOFFBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   }
  }
  if (insideFileCircle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/1.561), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.HELPFILEBUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/1.561), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.HELPFILEBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/1.561), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.HELPFILEBUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/1.561), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
  }
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equals("BACK")) {
   frame.switchScreenTo(new MainMenuPanel());
  }
  if (e.getActionCommand().equals("RESET SCORES")) {

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

 @Override
 public void mouseMoved(MouseEvent e) {
  Point point = e.getPoint();
  if (musicCircle.contains(point)) {
   insideMusicCircle = true;
  } else {
   insideMusicCircle = false;
  }
  if (helpFileCircle.contains(point)) {
   insideFileCircle = true;
  } else {
   insideFileCircle = false;
  }
  if (printCircle.contains(point)) {
   insidePrintCircle = true;
  } else {
   insidePrintCircle = false;
  }
  repaint();
 }

 @Override
 public void mouseClicked(MouseEvent e) {
  if (e.getButton() == MouseEvent.BUTTON1) {
   if (insideMusicCircle) {
    musicOn = !musicOn;
   } else if (insideFileCircle) {
    try {
     Runtime.getRuntime().exec(
       "hh.exe " + filePath + "Help File.chm");
    } catch (IOException ioe) {
     ioe.printStackTrace();
    }
   } else {
    if (insidePrintCircle) {
     PrintHighScores.sendToPrinter();
    }
   }
  }
 }

}
