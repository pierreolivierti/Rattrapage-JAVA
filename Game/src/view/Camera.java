package view;

import main.Game;
import model.Entity;

public class Camera {
	private Game game;
	private float xOffSet;
	private float yOffSet;
	
	// Constructor
	public Camera(Game game, float xOffSet, float yOffSet) {
		this.game = game;
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
	}

	public void move(float xAmt, float yAmt) {
		xOffSet += xAmt;
		yOffSet += yAmt;
	}
	
	public void centerOnEntity(Entity e) {
		xOffSet = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffSet = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
	}
	
	// Getters and Setters
	
	public float getxOffSet() {
		return xOffSet;
	}

	public void setxOffSet(float xOffSet) {
		this.xOffSet = xOffSet;
	}

	public float getyOffSet() {
		return yOffSet;
	}

	public void setyOffSet(float yOffSet) {
		this.yOffSet = yOffSet;
	}
	
	
}
