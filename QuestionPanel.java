package com.nutriblast;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 * This class will ask the user three multiple choice questions, the content of
 * which is based off the level they chose. If they get the questions right,
 * they will start off the game with additional time. If they get the questions
 * wrong, they will start off the game with negative time.
 * <p>
 * Time Spent: 3 hours
 * </p>
 * <p>
 * <b>Version 1</b> <br>
 * - Created the class <br>
 * </p>
 * 
 * 
 * @author Jesse
 * @version Final 5/6/2015
 */
public class QuestionPanel extends SwitchablePanel implements ActionListener {

 /**
  * A varible that holds the level.
  */
 int level;
 /**
  * An array of string containing the questions.
  */
 String[] questions = new String[3];
 /**
  * An array of strings containing all the possible answers.
  */
 String[] answers = new String[12];
 /**
  * An array of strings containing the three right answers.
  */
 String[] rightAnswers = new String[3];
 /**
  * An array of JRaioButtons used to select the answer to a question.
  */
 JRadioButton[] buttons = new JRadioButton[12];

 /**
  * Creates a question panel. The parameter level will determine what
  * questions will be asked.
  * 
  * @param level
  *            Determines the questions that will be asked.
  */
 public QuestionPanel(int level) {
  this.setLayout(null);
  this.level = level;
  try {
   readQuestions();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  displayButtons();
 }

 /**
  * <p>
  * Displays the questions and answers.
  * </p>
  * <p>
  * <b>Local Variables</b> <br>
  * <i>group []</i> - An array of button groups used to group questions into
  * their respective groups. <br>
  * <i>i</i> - A loop variable used to iterate through the the three groups.
  * <br>
  * <i>j</i> - A loop variable to iterate through the the buttons array,
  * initializing each RadioButton. <br>
  * </p>
  * <p>
  * <b>Internal Structures</b> <br>
  * A nested loop iterates through each JRadioButton in buttons, initilizing
  * each button and assigning it top a group.
  * </p>
  * 
  */
 private void displayButtons() {
  shuffleArray(answers);
  ButtonGroup[] group = { new ButtonGroup(), new ButtonGroup(),
    new ButtonGroup() };
  for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 4; j++) {
    buttons[j + i * 4] = new JRadioButton(answers[j + i * 4]);
    buttons[j + i * 4].setOpaque(false);
    buttons[j + i * 4].setFont(new Font("Corbel", Font.BOLD, 20));
    buttons[j + i * 4].setForeground(Color.WHITE);
    buttons[j + i * 4].setBounds((int)(GameFrame.PANEL_WIDTH/38.4) + i * (int)(GameFrame.PANEL_WIDTH/3),
      (int) (GameFrame.PANEL_HEIGHT / 2.2736) + j
        * (int) (GameFrame.PANEL_HEIGHT / 10.8), (int)(GameFrame.PANEL_WIDTH/3.84),
      (int) ((int)GameFrame.PANEL_HEIGHT/21.6));
    group[i].add(buttons[j + i * 4]);
    add(buttons[j + i * 4]);
   }
  }
  JButton button = new JButton("Submit Answers");
  button.setBounds((int)(GameFrame.PANEL_WIDTH / 2), (int)(GameFrame.PANEL_HEIGHT / 1.0588), (int)(GameFrame.PANEL_WIDTH / 9.6), 50);
  button.addActionListener(this);
  add(button);

 }

 /**
  * <p>
  * Reads questions from a file.
  * </p>
  * <p>
  * <b>Local Variables </b> <br>
  * <i>br</i> - A buffer Reader used to read data from a text file. <br>
  * <i>i</i> - A loop variable used to iterate through each question. <br>
  * <i>j</i> - A loop variable used to iterate through all of the answers. <br>
  * </p>
  * <p>
  * <b>Internal Structures</b> <br>
  * A nested for loop reads through a text file, initializing the question ,
  * rightAnswers and answers array.
  * </p>
  * 
  * @param level
  *            The level will determine what questions will be read in.
  * @throws IOException
  */
 public void readQuestions() throws IOException {
  BufferedReader br = new BufferedReader(new FileReader( filePath + "Level " + level + " Questions.JD"));
  for (int i = 0; i < 3; i++) {
   questions[i] = br.readLine();
   for (int j = 0; j < 4; j++) {
    answers[j + (i * 4)] = br.readLine();
   }
   rightAnswers[i] = answers[i * 4];
  }
  br.close();
 }

 /**
  * <p>
  * Used to shuffle the answers in a random order so that the right answer is
  * not always ion the same place.
  * </p>
  * <p>
  * <b>LocalVariables</b> <br>
  * <i> rnd </i> - An instance of the Random class, used generate a random
  * number. <br>
  * <i>j</i> - A loop variable that is used to divide the answers into sets <br>
  * of three so that the answers stay with their respective question. <br>
  * <i>i</i> - A loop variable used to iterate through each set of answers
  * and randomly shuffle them. <br>
  * <i>index</i> - A random index. <br>
  * <i>a</i> - A string that is used to hold the value of the string at index
  * in the answers array when swapping two items. <br>
  * </p>
  * <p>
  * <b>Internal Structures</b> A nested for loop divides the passed array
  * into 3 sections of four. This is because when we shuffle the array, we
  * dont want to shuffle the answer from one question into the answer of
  * another question. The internal for loop loops through each section, using
  * a Fisher-Yates shuffle to shuffle each section.
  * </p>
  * 
  * @param rightAnswers2
  */
 public void shuffleArray(String[] rightAnswers2) {
  Random rnd = new Random();
  for (int j = 0; j < 3; j++) {
   for (int i = (3 + (j * 4)); i > j * 4; i--) {
    int index = rnd.nextInt(3) + (j * 4);
    // Simple swap
    String a = rightAnswers2[index];
    rightAnswers2[index] = rightAnswers2[i];
    rightAnswers2[i] = a;
   }
  }
 }

 /**
  * Once the user submits their answers this method is called. This method
  * makes sure that they have selected an answer for all of the questions
  */
 @Override
 public void actionPerformed(ActionEvent e) {
  int numberOfSelectedItems = 0;
  int seconds = 0;
  for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 4; j++) {
    if (buttons[j + i * 4].isSelected()) {
     numberOfSelectedItems++;
     if (buttons[j + i * 4].getText().equals(rightAnswers[i])) {
      seconds += 10;
     } else {
      seconds -= 10;
     }
     break;
    }
   }
  }
  if (numberOfSelectedItems < 3) {
   displayError(
     "You have not selected an answer for all the questions!",
     "Title");
  } else {
   String message;  
   if (seconds > 0) {
    message = "rewared";
   } else {
    message = "deducted";
   }
   JOptionPane.showMessageDialog(this, "You have been " + message + " " + seconds +" seconds going into the game!", "Time", JOptionPane.DEFAULT_OPTION);
   GameFrame.levelPanel = new LevelPanel(level,seconds);
   GameFrame.levelPanel.run();
   frame.switchScreenTo (GameFrame.levelPanel);


  }
 }

 @Override
 /**
  * <p>
  * Paints everything on the screen
  * </p>
  * <p>
  * <b>Local Variables</b> <br>
  * <i>g2</i> A Graphics 2D object used to draw everything on the screen. <br>
  * <i>i</i> A loop[ variable used to draw the questions on the screen. <br>
  * </p>
  * <p>
  * <b>Internal Structures</b> <br>
  * A for-loop iterates through the questions array and draws them on the screen.
  * </p>
  * @param g A graphics object
  *  
  */
 public void paintComponent(Graphics g) {
  super.paintComponents(g);
  Graphics2D g2 = (Graphics2D) g;
  setAntialiasing(g2);
  g2.drawImage(ImageData.getImage(ImageData.QUESTION_BACKGROUND), 0, 0,
    null);
  g2.setFont(new Font("Corbel", Font.BOLD, 20));
  g2.setColor(Color.WHITE);
  for (int i = 0; i < 3; i++) {
   g2.drawString(Integer.toString(i + 1) + ". " + questions[i],
     (int) (GameFrame.PANEL_WIDTH / 38.4) + i
       * ((int) (GameFrame.PANEL_WIDTH / 3.0236)),
     (int) (GameFrame.PANEL_HEIGHT / 2.7));
  }

 }
}