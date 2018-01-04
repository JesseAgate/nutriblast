package com.nutriblast;
import java.util.Comparator;

public class HighScore {
	private String score;
	private String name;
	
	public HighScore(String name, String score) {
		this.name = name;
		this.score = score;
	}
	
	public String getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
}
