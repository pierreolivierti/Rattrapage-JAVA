package model;

import java.awt.Graphics;

import controller.Handler;

public abstract class State {
	public abstract void tick();
	public abstract void render(Graphics graphics);
	private static State currentState = null;
	protected Handler handler;	
	
	// Constructor
	public State(Handler handler) {
		this.handler = handler;
	}
	
	// Getters and Setters
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}

}
