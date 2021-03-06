package com.nutriblast;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.SwingWorker;

/**
 * Panel object that houses all three levels in the game.
 * <p>
 * <b>Time Spent: 7 hours</b>
 * </p>
 * <p>
 * <b>Version 1 </b> <br>
 * - Created the class <br>
 * <b>Version 2</b> <br>
 * - Added the Game Loop - Created the update method <br>
 * <b>Version 3</b> <br>
 * - Added collision detection <br>
 * <b>Version 4</b> <br>
 * - Updated the update method. The game loop is based off code by
 * TerranceN(http://compsci.ca/v3/viewtopic.php?t=25991)
 * </p>
 * 
 * @author Jesse
 * @version Final 08/06/2015
 */
public class LevelPanel extends GamePanel {
 /**
  * Regulates how fast the cannon is allowed to fire as well as when to put
  * the cannon back to its original position after recoiling.
  */
 private long fireTime;
 /**
  * The time at which the last molecule was spawned. Used for determine the
  * spawn rate of molecules.
  */
 private long spawnTime;
 /**
  * The base line time that should pass before another molecule spawns. Used
  * for determine the spawn rate of molecules.
  */
 private double spawnInterval;
 /**
  * A factor affecting the spawn rate of the Molecules. Shortens the
  * spawnInterval, increasing the spawn rate.
  */
 private double spawnAcceleration;
 /**
  * Increments the spawnAcceleration, speeding up spawn rate as time goes on.
  */
 private double spawnAccelerationRate;
 /**
  * Time used to count how long the player has survived for.
  */
 LevelTimer timer;
 /**
  * A boolean weather or not the game has been paused.
  */
 private boolean paused;
 /**
  * Refresh time of the games updating and drawing.
  */
 private final static int RefreshRate = 120;
 /**
  * An instance of the UserInput class. Handles input for the game.
  */
 UserInput input;
 /**
  * An instance of MovingObjectBox. Used to refresh the positions of all the
  * ammo.
  */
 private MovingObjectBox ammoBox;
 /**
  * An instance of MovingObjectBox. Used to refresh the positions of all the
  * molecules.
  */
 private MovingObjectBox moleculeBox;
 /**
  * An instance of gifBox. Holds an array of Gifs. Used to remove Gifs from
  * the screen once they have 'expired'
  */
 private GifBox gifBox;
 /**
  * The x Coordinate at which the molecules will start on their path.
  */
 private int moleculeStartX;
 /**
  * The y Coordinate at which the molecules will start on their path.
  */
 private int moleculeStartY;
 /**
  * The health of the player.
  */
 private int health;
 /**
  * The x Coordinate of the Cannons original position. Used to move the
  * cannon back to where it started after recoiling.
  */
 private int cannonX;
 /**
  * The y Coordinate of the Cannons original position. Used to move the
  * cannon back to where it started after recoiling.
  */
 private int cannonY;
 /**
  * The name(s) of the target molecule(s).
  */
 private ArrayList<String> targetMolecules = new ArrayList<String>();

 /**
  * Time that you must last to complete this level
  */
 private String targetTime;
 /**
  * The background image of the level
  */
 private Image backGround;
 /**
  * An int the contains the X-Coordinates of where the molecule ends its
  * path. Used for collision detection.
  */
 private int moleculeEndX;
 /**
  * An int the contains the X-Coordinates of where the molecule ends its
  * path. Used for collision detection.
  */
 private int moleculeEndY;
 /**
  * A n int used to hold the level
  */
 private int level;
 
 /**
  * Accessor for level
  * @return level
  */
 public int getLevel ()
 {
  return level;
 }
 

 /**
  * <p>
  * Creates an instance of the level panel. The game level that is created
  * depends on the parameter level.
  * </p>
  * <p>
  * <b>Internal Structures</b><br>
  * An if statement is used to assign the variables moleculeStartX,
  * moleculeStartY, moleculeEndX, moleculeEndY, backGround, moleculeBox and
  * targetMolecules.
  * 
  * @param level
  *            The level the constructor is making.
  * @param Time The time that is bieng subtracted or added to start time.
  */
 public LevelPanel(int level, int time) {
  this.level = level;
  if (level == 1) {
   moleculeStartX = (int) (GameFrame.PANEL_WIDTH / 3.25);
   moleculeStartY = (int) (GameFrame.PANEL_HEIGHT / 1.44);
   moleculeEndX = (int) (GameFrame.PANEL_WIDTH / 1.9896);
   moleculeEndY = GameFrame.PANEL_HEIGHT;
   backGround = ImageData.getImage((ImageData.LEVEL1));
   moleculeBox = new MoleculeBoxLevel1();
   targetMolecules.add("Water");
   targetMolecules.add("Salt");
  } else if (level == 2) {
   moleculeStartX = (GameFrame.PANEL_WIDTH / 2);
   moleculeStartY = -100;
   backGround = ImageData.getImage((ImageData.LEVEL2));
   moleculeBox = new MoleculeBoxLevel2();
   moleculeEndX = (int) (GameFrame.PANEL_WIDTH / 7.3846);
   moleculeEndY = GameFrame.PANEL_HEIGHT;
   targetMolecules.add("Protein");

  } else if (level == 3) {
   moleculeBox = new MoleculeBoxLevel3();
   backGround = ImageData.getImage(ImageData.LEVEL3);
   moleculeStartX = (int) (GameFrame.PANEL_WIDTH / 2.65);
   moleculeStartY = -100;
   moleculeEndX = (int) (GameFrame.PANEL_WIDTH / 3.555);
   moleculeEndY = (int) (GameFrame.PANEL_HEIGHT / 1.411764);
   targetMolecules.add("Carbs");
   targetMolecules.add("Fat");
  }
  targetTime = LevelTimer.secondsToTime((30 + level * 30) - time);
  cannonX = ImageData.getImage(ImageData.CANNON).getHeight(null);
  cannonY = (GameFrame.PANEL_HEIGHT / 4);
  cannon = new Cannon(cannonX, cannonY, 0);
  timer = new LevelTimer();
  health = 3;
  spawnTime = System.currentTimeMillis();
  spawnInterval = 3000 - ((level - 1) * 750);
  spawnAcceleration = 1;
  spawnAccelerationRate = level / 100;
  gifBox = new GifBox();
  ammoBox = new AmmunitionBox();
  input = new UserInput(this);
  setFocusable(true);
  setVisible(true);
 }

 /**
  * <p>
  * This method contains the game loop. The game loop will run as long as the
  * player is alive.
  * </p>
  * <p>
  * <b>Internal structures </b> <br>
  * A while loop iterates as long as the player is alive and the game is not
  * paused. In each iteration if the panel is not paused, the game is
  * updated, redrawn and then delayed. The delay time is calculated to make
  * sure that the game does not update at erratic rates. <br>
  * Once the while loop is exited, an if structure is used to detrmine what
  * panel to switch to.
  */
 public void run() {
  paused = false;
  input.resetKeys();
  SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
   @Override
   protected Void doInBackground() {
    while (health > 0 && !paused) {
     if (input.isKeyDown(KeyEvent.VK_ESCAPE)) {
      paused = true;
     }
     long time = System.currentTimeMillis();

     update();
     repaint();

     // delay for each frame - time it took for one frame
     time = (1000 / RefreshRate)
       - (System.currentTimeMillis() - time);

     if (time > 0) {
      try {
       Thread.sleep(time);
      } catch (Exception e) {
      }
     }
    }
    if (paused) {

     GameFrame.pausePanel = new PausePanel(takeScreenShot(0, 0,
       GameFrame.PANEL_WIDTH, GameFrame.PANEL_HEIGHT));
     frame.switchScreenTo(GameFrame.pausePanel);
    }
    else
    {
     GameFrame.outComePanel = new OutcomePanel ();
     frame.switchScreenTo (GameFrame.outComePanel);
    }
    return null;
   }

  };
  worker.execute();

 }

 /**
  * <p>
  * Takes a screen shot of the screen and returns the resulting image.
  * </p>
  * <p>
  * <b>Local Variables</b> <i>g2</i> A Graphics2D object used to capture the
  * screen.
  * </p>
  * 
  * @param x
  *            The X-Coordinate of the top left corner of the screen shot.
  * @param y
  *            The Y-Coordinate of the top left corner of the screen shot.
  * @param width
  *            The width of the capture image.
  * @param height
  *            The height of the capture image.
  * @return Returns the captured image
  */
 public BufferedImage takeScreenShot(int x, int y, int width, int height) {
  BufferedImage capture = new BufferedImage(width, height,
    BufferedImage.TYPE_INT_RGB);
  Graphics2D g2 = capture.createGraphics();
  this.paint(g2);
  return capture;

 }

 /**
  * <p>
  * Updates the game.
  * </p>
  * <p>
  * <b>Internal Structures </b> <br>
  * First, collisions are checked for, the timer counts, the positions and
  * paths of the moving objects in moleculeBox and ammoBox are updated. Next,
  * if the cannon is in a recoiled state and a sufficient amount of time has
  * passed, it is set back to its original position. Then health is deducted
  * if the player has stayed in one spot for too long. Then a molecule is
  * spawned if a sufficient amount of time has passed since the last one
  * spawned. Next, it is checked if the user has pressed any of the WASD keys
  * and if so, the cannons position is updated. Next, it is checked if the
  * arrow keys are pressed and rotates the cannon appropriately. If the space
  * bar is pressed, an ammo is added to ammoBox and the cannon is recoiled.
  * Finally, the cannon head position is updated and the spawnAcceleration is
  * incremented.
  * </p>
  * 
  */
 public void update() {
  timer.count();
  checkForCollision();
  ammoBox.updatePath();
  moleculeBox.updatePath();
  ammoBox.moveAlongPath();
  moleculeBox.moveAlongPath();
  gifBox.removeExpired();

  if (System.currentTimeMillis() - fireTime > 50) {
   cannon.setXCord(cannonX);
   cannon.setYCord(cannonY);
  }

  if (timer.getPositionTime() == 0) {
   health--;
   timer.resetPositionTime();
  }

  if ((spawnInterval / spawnAcceleration) + (Math.random() * 501) <= System
    .currentTimeMillis() - spawnTime) {
   
   int moleculeType = (int) (Math.random() * 5);
   moleculeBox.itemList.add(new Molecule(moleculeStartX,
     moleculeStartY, (int) 0, 1, ImageData
       .getMoleculeName(moleculeType), ImageData
       .getImage(moleculeType)));
   spawnTime = System.currentTimeMillis();
  }
  if (input.isKeyDown(KeyEvent.VK_W)) {
   cannon.setXCord(GameFrame.PANEL_WIDTH / 2);
   cannon.setYCord(cannon.getImage().getHeight(null));
   cannonX = cannon.getXCord();
   cannonY = cannon.getYCord();
   cannon.setAngle(Math.PI / 2);
   timer.resetPositionTime();
  }

  if (input.isKeyDown(KeyEvent.VK_A)) {
   cannon.setXCord(cannon.getIconHeight());
   cannon.setYCord(GameFrame.PANEL_HEIGHT / 4);
   cannonX = cannon.getXCord();
   cannonY = cannon.getYCord();
   cannon.setAngle(0);
   timer.resetPositionTime();

  }
  if (input.isKeyDown(KeyEvent.VK_S)) {
   cannon.setXCord(GameFrame.PANEL_WIDTH / 2);
   cannon.setYCord(GameFrame.PANEL_HEIGHT - cannon.getIconHeight());
   cannonX = cannon.getXCord();
   cannonY = cannon.getYCord();
   cannon.setAngle(Math.PI * 3 / 2);
   timer.resetPositionTime();

  }
  if (input.isKeyDown(KeyEvent.VK_D)) {
   cannon.setXCord(GameFrame.PANEL_WIDTH - cannon.getIconHeight());
   cannon.setYCord(GameFrame.PANEL_HEIGHT / 4);
   cannonX = cannon.getXCord();
   cannonY = cannon.getYCord();
   cannon.setAngle(Math.PI);
   timer.resetPositionTime();

  }
  if (input.isKeyDown(KeyEvent.VK_LEFT)) {
   cannon.setAngle(cannon.getAngle() - .03);

  } else if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
   cannon.setAngle(cannon.getAngle() + .03);
  }
  if (input.isKeyDown(KeyEvent.VK_SPACE)
    && System.currentTimeMillis() - fireTime > 300) {

   ammoBox.itemList.add(new MovingObject(cannon.getCannonHeadX(),
     cannon.getCannonHeadY(), 30, cannon.getAngle(), ImageData
       .getImage((ImageData.AMMO))));
   cannon.setXCord(cannon.getXCord()
     - ((int) (20 * Math.cos(cannon.getAngle()))));
   cannon.setYCord(cannon.getYCord()
     - ((int) (20 * Math.sin(cannon.getAngle()))));

   fireTime = System.currentTimeMillis();
  }
  cannon.setCannonHeadX((int) ((int) (cannon.getIconWidth() / 11.2228915) * Math
    .cos(cannon.getAngle())) + cannon.getXCord());

  cannon.setCannonHeadY((int) ((int) (cannon.getIconWidth() / 11.2228915) * Math
    .sin(cannon.getAngle())) + cannon.getYCord());

  if (spawnAcceleration < 4)
   spawnAcceleration += spawnAccelerationRate;
 }

 /**
  * <p>
  * This method detects for collisions between an ammo and a molecule.
  * </p>
  * <p>
  * <b>Local Variables </b> <br>
  * <i>xAmmo</i> - The X-Coordinate of the current ammo's center.<br>
  * <i>yAmmo</i> - The Y-Coordinate of the current ammo's center. <br>
  * <i>xMolecule</i> - The X-Coordinate of the current molecule's center.<br>
  * <i>yMolecule</i> - The Y-Coordinate of the current molecule's center. <br>
  * <i>i</i> - A loop variable used to iterate through every moving object in
  * ammoBox. <br>
  * <i>j</i> - A loop variable used to iterate through every molecule in
  * moleculeBox.
  * </p>
  * <p>
  * <b>Internal Structures </b> <br>
  * The ammo and molecule are treated like a circle. They are given a radius
  * and a center position. Pythagoras theorem is used to calculate the
  * distance between the two moving objects and determine whether or not a
  * collision has occurred. If a collision has occurred, the two moving
  * objects involved are removed. The players health is updated based upon
  * whether or not a target molecule has been shot. <br>
  * A second for loop is then entered to check for a collision between the
  * molecules and this levels path's ending. If a collision is detected, the
  * molecule is removed. The players health is then updated upon whether or
  * not the detected molecule was a target molecule.
  * </p>
  */
 public void checkForCollision() {
  double xAmmo, yAmmo, xMolecule, yMolecule;
  for (int i = 0; i < ammoBox.itemList.size(); i++) {
   xAmmo = ammoBox.itemList.get(i).getXCord()
     + (ammoBox.itemList.get(i).getIconWidth() / 2);
   yAmmo = ammoBox.itemList.get(i).getYCord()
     + (ammoBox.itemList.get(i).getIconHeight() / 2);
   for (int j = 0; j < moleculeBox.itemList.size(); j++) {
    xMolecule = moleculeBox.itemList.get(j).getXCord()
      + (moleculeBox.itemList.get(j).getIconWidth() / 2);
    yMolecule = moleculeBox.itemList.get(j).getYCord()
      + (moleculeBox.itemList.get(j).getIconHeight() / 2);
    double distance = Math.sqrt(Math.pow((xAmmo - xMolecule), 2)
      + Math.pow((yAmmo - yMolecule), 2));
    if (distance < (ammoBox.itemList.get(i).getIconHeight() / 2 + moleculeBox.itemList
      .get(j).getIconHeight() / 2)) {
     if (!((Molecule) moleculeBox.itemList.get(j))
       .nameEquals(targetMolecules)) {
      health--;
     }
     moleculeBox.itemList.remove(j);
     ammoBox.itemList.remove(i);
     gifBox.itemList.add(new Gif((int) (xMolecule - ImageData
       .getImage(ImageData.AMMO).getWidth(null)),
       (int) (yMolecule - ImageData.getImage(
         ImageData.AMMO).getHeight(null) / 2),
       ImageData.getImage(ImageData.EXPLOSION)));
     break;
    }
   }
  }

  for (int j = 0; j < moleculeBox.itemList.size(); j++) {
   if (moleculeBox.itemList.get(j).getXCord() > moleculeEndX - 10
     && moleculeBox.itemList.get(j).getXCord() < moleculeEndX + 10
     && moleculeBox.itemList.get(j).getYCord() > moleculeEndY - 10
     && moleculeBox.itemList.get(j).getYCord() < moleculeEndY + 10) {
    System.out.println("ya");
    if (((Molecule) moleculeBox.itemList.get(j))
      .nameEquals(targetMolecules)) {
     health--;
    }
    moleculeBox.itemList.remove(j);

   }

  }
 }

 /**
  * <p>
  * Draws all the MovingObjects in the ammoBox.
  * </p>
  * <p>
  * <b>Local Variables </b> <br>
  * <i>i</i> Loop variable used to iterate through each moving object in
  * ammoBox and draw it.
  * </p>
  * 
  * @param g2
  *            The graphics object drawing the ammo.
  */
 public void drawAmmo(Graphics2D g2) {
  for (int i = 0; i < ammoBox.itemList.size(); i++) {
   g2.drawImage(ammoBox.itemList.get(i).getImage(), ammoBox.itemList
     .get(i).getXCord(), ammoBox.itemList.get(i).getYCord(),
     null);
  }
 }

 /**
  * <p>
  * Draws all the MovingObjects in the ammoBox.
  * </p>
  * <p>
  * <b>Local Variables </b> <br>
  * <i>i</i> Loop variable used to iterate through each gif in gifBox and
  * draw it.
  * </p>
  * 
  * @param g2
  *            The graphics object drawing the gifs.
  */
 public void drawGif(Graphics2D g2) {
  for (int i = 0; i < gifBox.itemList.size(); i++) {
   g2.drawImage(gifBox.itemList.get(i).getImage(), gifBox.itemList
     .get(i).getXCord(), gifBox.itemList.get(i).getYCord(), this);
  }
 }

 /**
  * <p>
  * Draws all the MovingObjects in the ammoBox.
  * </p>
  * <p>
  * <b>Local Variables </b> <br>
  * <i>i</i> Loop variable used to iterate through each moving object in
  * moleculeBox and draw it.
  * </p>
  * 
  * @param g2
  *            The graphics object drawing the molecules.
  */
 public void drawMolecule(Graphics2D g2) {
  for (int i = 0; i < moleculeBox.itemList.size(); i++)
   g2.drawImage(moleculeBox.itemList.get(i).getImage(),
     moleculeBox.itemList.get(i).getXCord(),
     moleculeBox.itemList.get(i).getYCord(), null);
 }

 /**
  * <p>
  * Draws the players health on the screen.
  * </p>
  * <p>
  * <b>Local Variables</b> <br>
  * <i>i</i> - A loop variable that goes from 0 to players health -1. Used to
  * draw each heart.
  * </p>
  * <p>
  * <b>Internal Structures </b> <br>
  * Loop iterates from 0 - health-1, drawing a heart each time.
  * </p>
  * 
  * @param g2
  *            The Graphics2D object that draws the hearts.
  */
 public void drawHealth(Graphics2D g2) {
  for (int i = 0; i < health; i++) {
   g2.drawImage(ImageData.getImage(ImageData.HEART), (int)(GameFrame.PANEL_WIDTH/1.3714) - i * 150,
     75, null);
  }
 }

 /**
  * <p>
  * Overridden paint method draw everything on the screen.
  * </p>
  * <p>
  * <b>Local Variables</b><br>
  * <i>g2</i> - A Graphics2D object used to draw everything on the screen.
  * </p>
  * <p>
  * <b>Internal Structure</b> <br>
  * An if statement is used to determine what color the time should be drawn
  * in based of your time in relation to the goal time.
  * </p>
  * 
  * @param g
  *            A graphics object.
  */
 public void paintComponent(Graphics g) {
  Graphics2D g2 = (Graphics2D) g;
  setAntialiasing(g2);
  g2.drawImage(backGround, 0, 0, null);
  drawMolecule(g2);
  drawAmmo(g2);
  drawHealth(g2);
  drawGif(g2);
  g2.setFont(new Font("Bauhaus 93", Font.PLAIN, (int) (g.getFont()
    .getSize() * 5F)));
  if (LevelTimer.timeToSeconds(timer.getLevelTime()) >= LevelTimer
    .timeToSeconds(targetTime)) {
   g2.setColor(Color.green);
  } else {
   g2.setColor(Color.red);
  }
  g2.drawString(timer.getLevelTime(), GameFrame.PANEL_WIDTH / 100,
    GameFrame.PANEL_HEIGHT / 18);
  g2.setColor(Color.yellow);
  g2.drawString(" / " + targetTime, GameFrame.PANEL_WIDTH / 12,
    GameFrame.PANEL_HEIGHT / 18);
  g2.setFont(new Font("Bauhaus 93", Font.PLAIN, (int) (g.getFont()
    .getSize() * .95F)));
  g2.drawString("You must move in: " + timer.getPositionTime(),
    (int) (GameFrame.PANEL_WIDTH / 76.8),
    (int) (GameFrame.PANEL_HEIGHT / 5.4));
  drawCannon(g2);
  g2.dispose();
  g.dispose();
 }

}
