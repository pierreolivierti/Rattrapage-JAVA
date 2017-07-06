package model;

import java.awt.Graphics;

import main.Game;

public abstract class State {
	public abstract void tick();
	public abstract void render(Graphics graphics);
	private static State currentState = null;
	protected Game game;	
	
	public State(Game game) {
		this.game = game;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}

}