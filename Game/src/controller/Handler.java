package controller;

import java.util.Random;

import controller.KeyManager;
import main.Game;
import model.Enemy;
import model.Player;
import model.World;
import view.Camera;

public class Handler {
	
	private Game game;
	private World world;
	private Enemy enemy;
	private Player player;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	
	public void createEnemy() {
		this.world.newEnemy(new Enemy(this, new Random().nextInt(900), new Random().nextInt(900)));
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
