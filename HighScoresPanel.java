package com.nutriblast;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The HighScoresPanel class is a subclass panel object that displays the high
 * scores of each of the three levels. Users can switch between levels to
 * display their respective high scores. High scores are sorted in descending
 * order from highest to lowest.
 * <p>
 * Time spent: 4 hours
 * </p>
 * 
 * @author Daniel Zhang
 * @version FINAL 6/6/2015
 */
public class HighScoresPanel extends MenuPanel {

	/**
	 * Stores the maximum number of high scores that can be displayed.
	 */
	private static final int MAX = 10;

	/**
	 * Represents the clickable area of the "next" button.
	 */
	private Ellipse2D.Double nextCircle = new Ellipse2D.Double(
			GameFrame.PANEL_WIDTH / 54.857, GameFrame.PANEL_HEIGHT / 3.661,
			GameFrame.PANEL_WIDTH / 6.857, GameFrame.PANEL_WIDTH / 6.857);
	/**
	 * Represents the clickable area of the "back" button.
	 */
	private Ellipse2D.Double backCircle = new Ellipse2D.Double(
			(int) (GameFrame.PANEL_WIDTH / 61.935),
			GameFrame.PANEL_HEIGHT / 1.421, GameFrame.PANEL_WIDTH / 6.857,
			GameFrame.PANEL_WIDTH / 6.857);

	/**
	 * Booleans involved in determining whether the mouse has entered an Ellipse
	 * object or has been clicked.
	 */
	private boolean insideBackCircle = false, insideNextCircle = false,
			clicked = false;

	/**
	 * Stores the level of the high scores currently being displayed.
	 */
	private static int levelNumber = 1;

	ArrayList<HighScore> scoresList = new ArrayList<HighScore>();

	public void passNewScore(HighScore score, int level) {
		scoresList.add(score);
		if (!scoresList.isEmpty()) {
			sort(scoresList, score);
			if (scoresList.size() > 10) {
				scoresList.remove(scoresList.size());
			}
			writeToFile(level);
		}
	}

	private void sort(ArrayList<HighScore> array, HighScore score) {
//		Collections.sort(array, new Comparator<HighScore>() {
//
//			@Override
//			public int compare(HighScore o1, HighScore o2) {
//
//				if (LevelTimer.timeToSeconds(o1.getScore(0)) > LevelTimer
//						.timeToSeconds((String) o1)) {
//					return 1;
//				} else if (LevelTimer.timeToSeconds((String) arg0) == LevelTimer
//						.timeToSeconds((String) o1)) {
//					return 0;
//				} else {
//					return -1;
//				}
//
//			}
//
//		});

		// int temp, x;
		// HighScore tempScore;
		// for (int i = 1; i < array.size(); i++) {
		// tempScore = array.get(i);
		// temp = LevelTimer.timeToSeconds((array.get(i).getScore()));
		// for (x = i - 1; x > -1 &&
		// LevelTimer.timeToSeconds((array.get(i).getScore())) < temp; x--) {
		// array.set(x+1, array.get(x));
		// }
		// array.set(x+1, tempScore);
		// }
	}

	public void writeToFile(int level) {
		String fileName;
		if (level == 1) {
			fileName = "Highscores Level 1.JD";
		} else if (level == 2) {
			fileName = "Highscores Level 2.JD";
		} else {
			fileName = "Highscores Level 3.JD";
		}
		File scoresFile = new File(filePath + fileName);
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(scoresFile));
			writer.println(HEADER);
			for (HighScore score : scoresList) {
				writer.println(score.getName());
				writer.println(score.getScore());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile(int level) {
		String fileName;
		if (level == 1) {
			fileName = "Highscores Level 1.JD";
		} else if (level == 2) {
			fileName = "Highscores Level 2.JD";
		} else {
			fileName = "Highscores Level 3.JD";
		}
		File scoresFile = new File(filePath + fileName);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					scoresFile));
			if (reader.readLine().equals(HEADER)) {
				String tempName = "";
				ArrayList<String> tempList = new ArrayList<String>();
				while (tempName != null) {
					tempName = reader.readLine();
					if (tempName != null) {
						tempList.add(tempName);
					}
				}
				for (int i = 0; i < tempList.size() - 1; i += 2) {
					scoresList.add(new HighScore(tempList.get(i), tempList
							.get(i + 1)));
				}
				//sort(scoresList, score);
			} else {
				scoresFile.delete();
				createHighScoresFile(level);
			}
		} catch (IOException e) {
			createHighScoresFile(level);
		}

	}

	/**
	 * Default constructor. Loads images, fonts, and adds specified event
	 * listeners.
	 */
	public HighScoresPanel() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(
					fontPath + "Champagne & Limousines.ttf")));
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		levelNumber = 1;
		readFromFile(1);
	}

	private static final String HEADER = "Icosahedron Entertainment "
			+ "|| Daniel and Jesse || Nutriblast File";

	private void createHighScoresFile(int level) {
		try {
			String fileName;
			if (level == 1) {
				fileName = "Highscores Level 1.JD";
			} else if (level == 2) {
				fileName = "Highscores Level 2.JD";
			} else {
				fileName = "Highscores Level 3.JD";
			}
			File scoresFile = new File(filePath + fileName);
			PrintWriter writer = new PrintWriter(new FileWriter(scoresFile));
			writer.println(HEADER);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Performs descending insertion sort on an array of HighScore objects.
	 */
	private void sort(HighScore[] array) {
		int temp, x;
		HighScore tempScore;
		for (int i = 1; i < array.length; i++) {
			tempScore = array[i];
			temp = LevelTimer.timeToSeconds((array[i].getScore()));
			for (x = i - 1; x > -1
					&& LevelTimer.timeToSeconds((array[x].getScore())) < temp; x--) {
				array[x + 1] = array[x];
			}
			array[x + 1] = tempScore;
		}
	}

	/**
	 * Displays a specified array of HighScore objects on the screen.
	 * 
	 * @param array
	 *            the array of HighScore objects being displayed.
	 * @param g
	 *            Graphics object used in drawing commands of paintComponent.
	 */
	private void displayScores(ArrayList<HighScore> array, Graphics g) {
		for (int i = 0; i < array.size(); i++) {
			if (i != 9) {
				g.drawString((i + 1) + "", 487, 460 + 61 * i);
			} else {
				g.drawString((i + 1) + "", 472, 460 + 61 * i);
			}
			g.drawString(array.get(i).getName(), 740, 460 + 61 * i);
			g.drawString(array.get(i).getScore() + "", 1440, 460 + 61 * i);
		}
	}

	/**
	 * Displays the background corresponding to Level 1 and displays Level 1's
	 * high scores.
	 * 
	 * @param g
	 *            Graphics object used in drawing commands of paintComponent.
	 */
	private void paintLevel1(Graphics g) {
		g.drawImage(ImageData.getImage(ImageData.HIGHSCORES_LEVEL1), 0, 0, null);
		this.readFromFile(levelNumber);
		if (!scoresList.isEmpty()) {
			displayScores(scoresList, g);
		}
	}

	/**
	 * Displays the background corresponding to Level 2 and displays Level 2's
	 * high scores.
	 * 
	 * @param g
	 *            Graphics object used in drawing commands of paintComponent.
	 */
	private void paintLevel2(Graphics g) {
		g.drawImage(ImageData.getImage(ImageData.HIGHSCORES_LEVEL2), 0, 0, null);
		this.readFromFile(levelNumber);
		if (!scoresList.isEmpty()) {
			displayScores(scoresList, g);
		}
	}

	/**
	 * Displays the background corresponding to Level 3 and displays Level 3's
	 * high scores.
	 * 
	 * @param g
	 *            Graphics object used in drawing commands of paintComponent.
	 */
	private void paintLevel3(Graphics g) {
		g.drawImage(ImageData.getImage(ImageData.HIGHSCORES_LEVEL3), 0, 0, null);
		this.readFromFile(levelNumber);
		if (!scoresList.isEmpty()) {
			displayScores(scoresList, g);
		}
	}

	/**
	 * Paints the entire foreground of the JPanel using the specified commands.
	 * Sets all string drawing to use the "Champagne and Limousines" font and to
	 * be done in a white colour.
	 * <p>
	 * <b>Local Variables </b> <br>
	 * <i>g2</i> - Reference to a Graphics2D object that allows Antialiasing to
	 * be set.<br>
	 * </p>
	 * <p>
	 * <b>Internal Structures </b> <br>
	 * 
	 * 
	 * @param g
	 *            Graphics object used in drawing commands of paintComponent.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		setAntialiasing(g2);
		g.setColor(Color.white);
		g.setFont(new Font("Champagne & Limousines", Font.PLAIN, (int) (g
				.getFont().getSize() * 3F)));
		if (levelNumber == 1) {
			paintLevel1(g);
		} else if (levelNumber == 2) {
			paintLevel2(g);
		} else {
			paintLevel3(g);
		}
		if (insideNextCircle) {
			g.drawImage(ImageData.getImage(ImageData.HOVERED),
					(int) (GameFrame.PANEL_WIDTH / -60), 264, null);
			if (clicked) {
				g.drawImage(ImageData.getImage(ImageData.NEXTBUTTON_CLICKED),
						(int) (GameFrame.PANEL_WIDTH / -42.667),
						(int) (GameFrame.PANEL_HEIGHT / 4.075), null);
			} else {
				g.drawImage(ImageData.getImage(ImageData.NEXTBUTTON_UNCLICKED),
						(int) (GameFrame.PANEL_WIDTH / -42.667),
						(int) (GameFrame.PANEL_HEIGHT / 4.075), null);
			}
		} else {
			g.drawImage(ImageData.getImage(ImageData.NEXTBUTTON_UNCLICKED),
					(int) (GameFrame.PANEL_WIDTH / -42.667),
					(int) (GameFrame.PANEL_HEIGHT / 4.075), null);
		}
		if (insideBackCircle) {
			g.drawImage(ImageData.getImage(ImageData.HOVERED),
					(int) (GameFrame.PANEL_WIDTH / -54.857),
					(int) (GameFrame.PANEL_HEIGHT / 1.455), null);
			if (clicked) {
				g.drawImage(ImageData.getImage(ImageData.BACKBUTTON_CLICKED),
						(int) (GameFrame.PANEL_WIDTH / -40),
						(int) (GameFrame.PANEL_HEIGHT / 1.483), null);
			} else {
				g.drawImage(ImageData.getImage(ImageData.BACKBUTTON_UNCLICKED),
						(int) (GameFrame.PANEL_WIDTH / -40),
						(int) (GameFrame.PANEL_HEIGHT / 1.483), null);
			}
		} else {
			g.drawImage(ImageData.getImage(ImageData.BACKBUTTON_UNCLICKED),
					(int) (GameFrame.PANEL_WIDTH / -40),
					(int) (GameFrame.PANEL_HEIGHT / 1.483), null);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point point = e.getPoint();
		if (backCircle.contains(point)) {
			insideBackCircle = true;
		} else {
			insideBackCircle = false;
		}
		if (nextCircle.contains(point)) {
			insideNextCircle = true;
		} else {
			insideNextCircle = false;
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
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (insideBackCircle) {
				levelNumber--;
				if (levelNumber == 0) {
					frame.switchScreenTo(new MainMenuPanel());
				}
			} else {
				if (insideNextCircle) {
					levelNumber++;
					if (levelNumber == 4) {
						frame.switchScreenTo(new MainMenuPanel());
					}
				}
			}
		}
	}
}
