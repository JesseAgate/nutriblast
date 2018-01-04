package com.nutriblast;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPanel extends SwitchablePanel implements ActionListener, MouseListener,
  MouseMotionListener {

 static GameFrame frame;
 protected ArrayList<JButton> buttonList = new ArrayList<JButton>();

 protected static final int PANEL_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
 protected static final int PANEL_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
 

 
 public MenuPanel() {
  
 }
 

 public GameFrame getFrame() {
  return frame;
 }

 public void setFrame(GameFrame newFrame) {
  MenuPanel.frame = newFrame;
 }

 public void actionPerformed(ActionEvent ae) {
 }

 public void mouseDragged(MouseEvent arg0) {
 }

 public void mouseMoved(MouseEvent arg0) {
 }

 public void mouseClicked(MouseEvent arg0) {
 }

 public void mouseEntered(MouseEvent arg0) {
 }

 public void mouseExited(MouseEvent arg0) {
 }

 public void mousePressed(MouseEvent arg0) {
 }

 public void mouseReleased(MouseEvent arg0) {
 }
}
