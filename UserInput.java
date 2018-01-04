package com.nutriblast;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Code from TerranceN (http://compsci.ca/v3/viewtopic.php?t=25991) Class made
 * to handle in game user input.
 * <p>
 * Time Spent: Negligible.
 * </p>
 * <p>
 * <b> Version 1</b> <br>
 * - Edited TerranceN class.
 * </p>
 * 
 * @author TerraceN Edited by Jesse
 * @version Final 5/17/2015
 */
public class UserInput implements KeyListener {

	/**
	 * An array of boolean values, each value corresponds to a key on your
	 * keyboard. If you press a key, the value corresponding to that key is set
	 * to true. If that key is released, the value corresponding to that key
	 * becomes false.
	 */
	private boolean[] keyList = new boolean[256];

	/**
	 * <p>
	 * Initializes the boolean array and adds a KeyListener to the specified
	 * component.
	 * </p>
	 * <p>
	 * <b>Local Variables</b> <br>
	 * <I>i</i> - Loop variable used to initialize keyList.
	 * </p>
	 * <p>
	 * <b>Internal Structures</b><br>
	 * A for loop iterates through each index of keyList to initialize each one.
	 * </p>
	 * 
	 * @param c The component this KeyListener is being added to.
	 */
	public UserInput(Component c) {
		resetKeys();
		c.addKeyListener(this);
	}

	/**
	 * Will return true or false defendant upon whether or not the specified key
	 * is being pressed.
	 * 
	 * @param key
	 *            The key you would like to know whether or not it is being
	 *            pressed.
	 * @return Returns whether or not the specified key is being pressed.
	 */
	public boolean isKeyDown(int key) {
		return keyList[key];
	}

	/**
	 * Called when a key is pressed.
	 * 
	 * @param e
	 *            A KeyEvent
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keyList[e.getKeyCode()] = true;
		}
	}

	/**
	 * Called when key is released. Sets the specific key released in keyList to
	 * false.
	 * 
	 * @param e
	 *            A KeyEvent
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keyList[e.getKeyCode()] = false;
		}
	}

	/**
	 * Resets all the keys. Used to make sure input does not lock up when switching screens.
	 */
	public void resetKeys()
	{
		for (int i = 0; i < 256; i++) {
			keyList[i] = false;
		}
	}
	/**
	 * Empty implementation
	 * 
	 * @param e
	 *            A KeyEvent
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

}
