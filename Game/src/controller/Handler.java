package controller;

import controller.KeyManager;
import main.Game;
import model.World;
import view.Camera;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public Camera getCamera(){
		return game.getCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
