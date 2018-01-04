package com.nutriblast;
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


public class LevelSelectPanel extends MenuPanel {
 Ellipse2D.Double level1Circle = new Ellipse2D.Double(325, 470, 280, 280);
 Ellipse2D.Double level2Circle = new Ellipse2D.Double(822, 470, 280, 280);
 Ellipse2D.Double level3Circle = new Ellipse2D.Double(1319, 470, 280, 280);

 private boolean clicked = false, insideLevel1Circle = false, insideLevel2Circle = false,
   insideLevel3Circle = false; 
 private JButton backButton;
 
 public LevelSelectPanel() {
  this.setLayout(null);
  backButton = new JButton(new ImageIcon(ImageData.getImage(ImageData.BACKBUTTON)));
  backButton.setBounds(PANEL_WIDTH/2 - 105, 750, 210, 140);
  backButton.setActionCommand("BACK");
  backButton.addActionListener(this);
  this.add(backButton);
  this.addMouseListener(this);
  this.addMouseMotionListener(this);
 }
 
 
 @Override
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.drawImage(ImageData.getImage(ImageData.LEVELSELECT_BACKGROUND),0,0,null);
  if (insideLevel1Circle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/7.934), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.LEVEL1BUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/7.742), (int)(GameFrame.PANEL_HEIGHT/2.5), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.LEVEL1BUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.742), (int)(GameFrame.PANEL_HEIGHT/2.5), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.LEVEL1BUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/7.742), (int)(GameFrame.PANEL_HEIGHT/2.5), null);
  }
  if (insideLevel2Circle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/2.57), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.LEVEL2BUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/2.573), (int)(GameFrame.PANEL_HEIGHT/2.488), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.LEVEL2BUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/2.573), (int)(GameFrame.PANEL_HEIGHT/2.488), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.LEVEL2BUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/2.573), (int)(GameFrame.PANEL_HEIGHT/2.488), null);
  }
  if (insideLevel3Circle) {
   g.drawImage(ImageData.getImage(ImageData.HOVERED), (int)(GameFrame.PANEL_WIDTH/1.561), (int)(GameFrame.PANEL_HEIGHT/2.454), null);
   if (clicked) {
    g.drawImage(ImageData.getImage(ImageData.LEVEL3BUTTON_CLICKED), (int)(GameFrame.PANEL_WIDTH/1.551), (int)(GameFrame.PANEL_HEIGHT/2.488), null);
   } else {
    g.drawImage(ImageData.getImage(ImageData.LEVEL3BUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/1.551), (int)(GameFrame.PANEL_HEIGHT/2.488), null);
   }
  } else {
   g.drawImage(ImageData.getImage(ImageData.LEVEL3BUTTON_UNCLICKED), (int)(GameFrame.PANEL_WIDTH/1.551), (int)(GameFrame.PANEL_HEIGHT/2.488), null);
  }
 }
 
 @Override
 public void mouseMoved(MouseEvent e) {
  Point point = e.getPoint();
  if (level1Circle.contains(point)) {
   insideLevel1Circle = true;
  } else {
   insideLevel1Circle = false;
  }
  if (level2Circle.contains(point)) {
   insideLevel2Circle = true;
  } else {
   insideLevel2Circle = false;
  }
  if (level3Circle.contains(point)) {
   insideLevel3Circle = true;
  } else {
   insideLevel3Circle = false;
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
 public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equals("BACK")) {
   frame.switchScreenTo(new MainMenuPanel());
  }
 }
 
 @Override
 public void mouseClicked(MouseEvent e) {
  if (e.getButton() == MouseEvent.BUTTON1) {
   if (insideLevel1Circle) {
    frame.switchScreenTo (new QuestionPanel (1));
    
   }
   else if (insideLevel2Circle) {
    frame.switchScreenTo (new QuestionPanel (2));
     
    }
   else
   {
    frame.switchScreenTo (new QuestionPanel (3));
   }
   }
  }
 }

