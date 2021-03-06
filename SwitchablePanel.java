package com.nutriblast;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SwitchablePanel extends JPanel {
  
   protected String filePath = (System.getProperty("user.dir").substring(0,System.getProperty("user.dir").lastIndexOf("\\src\\")) + "\\resources\\data\\");
 protected String fontPath = (System.getProperty("user.dir").substring(0,System.getProperty("user.dir").lastIndexOf("\\src\\")) + "\\resources\\fonts\\");
  
 /**
  * Displays a JOptionPane error message with a specified message and title.
  * 
  * @param message
  *            the error message being conveyed to the user.
  * @param title
  *            the header of the JOptionPane dialog box.
  */
 protected void displayError(String message, String title) {
  Toolkit.getDefaultToolkit().beep();
  JOptionPane.showMessageDialog(this, message, title,
    JOptionPane.ERROR_MESSAGE);
 }

 protected static GameFrame frame;
 
 /**
  * <p>
  * Sets the rendering hints of the passed Graphics2D
  * </p>
  * <p>
  * <b>Local Variables</b> <br>
  * <i>rh</i> An instance of the RenderingHints class used to set the
  * rendering hints on the passed Graphics2D object.
  * </p>
  * @param g2 The Graphics2D object that is given reneringHints.
  */
 public void setAntialiasing(Graphics2D g2) {
  RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);

  rh.put(RenderingHints.KEY_RENDERING,
    RenderingHints.VALUE_RENDER_QUALITY);
  g2.setRenderingHints(rh);
 }
 
 public void setFrame(GameFrame newFrame) {
  SwitchablePanel.frame = newFrame;
 }
}
