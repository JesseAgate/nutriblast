package com.nutriblast;
//Copyright 2015 Chris Cambell
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
/**
 * Class made to load and scale images
 * <p>
 * Time Spent: 2 Hours
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created class - Did file IO  <br>
 * - Set it up to scale a temporary image <br>
 * <b>Version 2 </b> <br>
 * - Added constants to make image retrieval easier <br>
 * - Added an Array of  strings that keeps track of the name of each image <br>
 * <b>Version 3</b> <br>
 * - Implemented scaling for all images.
 * </p>
 * 
 * @author Jesse
 * @version Final
 */
public class ImageData {

 static public final int CARB = 0;
 static public final int PROTEIN = 1;
 static public final int WATER = 2;
 static public final int FAT = 3;
 static public final int SALT = 4;
 static public final int AMMO = 5;
 static public final int CANNON = 6;
 static public final int HEART = 7;
 static public final int LEVEL1 = 8;
 static public final int LEVEL2 = 9;
 static public final int LEVEL3 = 10;
 static public final int MAIN_MENU_BACKGROUND = 11;
 static public final int PLAYBUTTON_UNCLICKED = 12;
 static public final int HELPBUTTON_UNCLICKED = 13;
 static public final int OPTIONSBUTTON_UNCLICKED = 14;
 static public final int EXITBUTTON_UNCLICKED = 15;
 static public final int HIGHSCORESBUTTON_UNCLICKED = 16;
 static public final int PLAYBUTTON_CLICKED = 17;
 static public final int HELPBUTTON_CLICKED = 18;
 static public final int OPTIONSBUTTON_CLICKED = 19;
 static public final int EXITBUTTON_CLICKED = 20;
 static public final int HIGHSCORESBUTTON_CLICKED = 21;
 static public final int HOVERED = 22; 
 static public final int CONTROLS_BACKGROUND = 23; 
 static public final int BACKBUTTON_CLICKED = 24; 
 static public final int NEXTBUTTON_CLICKED = 25; 
 static public final int BACKBUTTON_UNCLICKED = 26; 
 static public final int NEXTBUTTON_UNCLICKED = 27; 
 static public final int LEVELSELECT_BACKGROUND = 28;
 static public final int LEVEL1BUTTON_CLICKED = 29;
 static public final int LEVEL1BUTTON_UNCLICKED = 30;
 static public final int LEVEL2BUTTON_CLICKED = 31;
 static public final int LEVEL2BUTTON_UNCLICKED = 32;
 static public final int LEVEL3BUTTON_CLICKED = 33;
 static public final int LEVEL3BUTTON_UNCLICKED = 34;
 static public final int BACKBUTTON = 35;
 static public final int OUTCOME_BACKGROUND = 36;
 static public final int CONTINUE_BUTTON = 37;
 static public final int MAINMENU_BUTTON = 38;
 static public final int HIGHSCORES_LEVEL1 = 39;
 static public final int HIGHSCORES_LEVEL2 = 40;
 static public final int HIGHSCORES_LEVEL3 = 41;
 static public final int OPTIONS_BACKGROUND = 42;
 static public final int PRINTBUTTON_CLICKED = 43;
 static public final int PRINTBUTTON_UNCLICKED = 44;
 static public final int HELPFILEBUTTON_CLICKED = 45;
 static public final int HELPFILEBUTTON_UNCLICKED = 46;
 static public final int MUSICONBUTTON_CLICKED = 47;
 static public final int MUSICOFFBUTTON_CLICKED = 48;
 static public final int MUSICONBUTTON_UNCLICKED = 49;
 static public final int MUSICOFFBUTTON_UNCLICKED = 50;
 static public final int RESETBUTTON = 51;
 static public final int RESUMEBUTTON = 52;
 static public final int HELPBUTTON = 53;
 static public final int INFO1 = 54;
 static public final int INFO2 = 55;
 static public final int INFO3 = 56;
 static public final int INFO4 = 57;
 static public final int INFO5 = 58;
 static public final int TRANSITION = 59;
 static public final int QUESTION_BACKGROUND = 60;
 static public final int EXPLOSION = 61;
 static public final int COMPANY_LOGO = 62;
 
 static private String[] moleculeName = { "Carbs", "Protein", "Water","Fat","Salt"};
 static private Image[] images = new Image[63];
 static private String path = (System.getProperty("user.dir").substring(0,System.getProperty("user.dir").lastIndexOf("\\src")) + "\\resources\\images\\");

 /**
  * <p>
  * Loads and scales all the images required to play the game.
  * </p>
  * <p>
  * <b>Local Variables</b> <br>
  * <i>br</i> - A BufferedReader, used to read in the names of the images. <br>
  * <i>factor</i> - The factor that all images should be scaled by. <br>
  * <i>newY</i> - The new height of the image after scaling. <br>
  * <i>newX</i> - The new width of the image after scaling. <br>
  * <i>i</i> A for loop used to create all the images and scale them. <br>
  * </p>
  * <p>
  * <b>Internal Structures</b> <br>
  * A for loop iterates through each image and scales each one.
  * </p>
  *  
  * @throws IOException
  */
 public static void loadAndScaleImages() throws IOException {
  BufferedReader br = new BufferedReader(new FileReader(path + "imageTracker.txt"));
  for (int i = 0; i < 61; i++) {
   images[i] = ImageIO.read(new File(path
     + br.readLine()));
   double factor = 1920.0 / Toolkit.getDefaultToolkit()
     .getScreenSize().getWidth();
   int newY = (int) (images[i].getHeight(null) / factor);
   int newX = (int) (images[i].getWidth(null) / factor);
   images[i] = Scalr.resize((BufferedImage) images[i], newX, newY,
     null);
  }
  images[61] = Toolkit.getDefaultToolkit().createImage(
    path + br.readLine());
  images [62] = ImageIO.read(new File (path + br.readLine()));
  br.close();
 }
 /**
  * Accessor for images[]
  * 
  * @param x The index where the image you want is.
  * @return Returns an Image.
  */
 public static Image getImage(int x) {
  return images[x];
 }

 /**
  * Accessor for moleculeName []
  * 
  * @param x The index where the string you want is.
  * @return Returns a molecule name.
  */
 public static String getMoleculeName(int x) {
  return moleculeName[x];
 }
}
