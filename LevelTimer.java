package com.nutriblast;
/**
 * 
 * This class times the amount of time the player survived for.
 * <p>
 * Time Spent 1.5 Hour.
 * </p>
 * <p>
 * <b>Version 1 </b> <br>
 * - Created Class<br>
 * - Updated count method to account allow it to be paused.
 * </p>
 * 
 * 
 * @author Jesse
 * @version Final 23/05/2015
 */

public class LevelTimer {
	/**
	 * Holds the amount of time untill the player must switch their position.
	 */
	private int positionSeconds;
	/**
	 * Holds the number of seconds that have passed in this level.
	 */
	private int levelSeconds;
	/**
	 * A long that stores the time at which the timer started in milli seconds.
	 */
	private long previousTime;
	/**
	 * Time passed since the timer started represented as a string
	 */
	private String time = "0:00";

	/**
	 * Default Constructor. Starts the timer.
	 */
	public LevelTimer() {
		time = "0:00";
		previousTime = System.currentTimeMillis();
		levelSeconds = 0;
		positionSeconds = 5;
	}

	/**
	 * <p>
	 * Increments and decrements levelSeconds and positionSeconds.
	 * </p>
	 * <p>
	 * <b>Local Variables</b> <br>
	 * <i>currentTime</i> - A long that gets the current system time. Used to
	 * check if a second has passed.
	 * </p>
	 * <p>
	 * <b>Internal Structures</b> <br>
	 * An if statement determines if 1 second has passed since the last
	 * incrementation.
	 * </p>
	 * 
	 */
	public void count() {
		long currentTime = System.currentTimeMillis();
		if (currentTime - previousTime > 1000) {
			previousTime = currentTime;
			levelSeconds++;
				positionSeconds--;
			time = secondsToTime(levelSeconds);
		}

	}

	/**
	 * <p>
	 * Converts seconds into a string of time.
	 * </p>
	 * <p>
	 * <b>Local Variables</b> <br>
	 * <i>minutes</i> - An int used to hold how many minutes have passed. <br>
	 * <i>secondsLeft</i> - An int used to hold how many seconds there are after
	 * some have been converted into minutes. <br>
	 * <i>spacer</i> - A String used to space minutes and seconds in the time
	 * variable. <br>
	 * </p>
	 * <p>
	 * <b>Internal Structures</b> <br>
	 * The parameter time is converted into a string of time with the format of
	 * minute:seconds. First, the number of minutes are found and then the
	 * number of seconds left after minutes have been accounted for is found.
	 * The contents of spacer is determined by how many seconds left there are.
	 * </p>
	 * 
	 * @param time
	 *            The time in seconds that is being converted.
	 * @return The formate string of time.
	 */
	public static String secondsToTime(int time) {
		int minutes = time / 60;
		int secondsLeft = time - (minutes * 60);
		String spacer;
		if (secondsLeft / 10 > 0) {
			spacer = ":";
		} else {
			spacer = ":0";
		}
		return (minutes + spacer + secondsLeft);

	}

	/**
	 * <p>
	 * Converts a string displaying time into the equivalent in milliseconds.
	 * </p>
	 * <p>
	 * <b>Local Variables</b><br>
	 * <i>minutes</i> - The number of minutes there are on the clock. <br>
	 * <i>seconds</i> - The number of seconds there are on the clock.
	 * 
	 * @param time
	 *            The time that is to be converted.
	 * @return The equivalent time in milliseconds.
	 */
	public static int timeToSeconds(String time) {
		int minutes = Integer.parseInt(time.substring(0, time.indexOf(":")));
		int seconds = Integer.parseInt(time.substring(time.indexOf(":") + 1));
		return (minutes * 60) + (seconds);
	}

	/**
	 * Gets the time passed since the level has started.
	 * 
	 * @return time The time passed in minutes in seconds in string form.
	 */
	public String getLevelTime() {
		return time;
	}

	/**
	 * Resets the positionTimer
	 */
	public void resetPositionTime() {
		positionSeconds = 5;
	}
	/**
	 * Accessor for level seconds.
	 * @return
	 */
	public int getLevelSeconds ()
	{
		return levelSeconds;
	}

	/**
	 * Gets the time left until you have to switch positions @ return
	 * positionSeconds The amount of time left before you must switch positions.
	 */
	public int getPositionTime() {
		return positionSeconds;
	}
}
