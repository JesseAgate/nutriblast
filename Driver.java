package com.nutriblast;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Driver {

 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    try {
     UIManager.setLookAndFeel(UIManager
       .getSystemLookAndFeelClassName());
    } catch (InstantiationException | ClassNotFoundException
      | IllegalAccessException| UnsupportedLookAndFeelException e) {
    }
    try {
     ImageData.loadAndScaleImages();
    } catch (IOException e) {
     e.printStackTrace();
    }
    new GameFrame();
   }
  });
 }
}
