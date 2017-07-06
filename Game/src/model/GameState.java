package model;

import java.awt.Graphics;

import main.Game;

public class GameState extends State {
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics graphics) {
		player.render(graphics);
	}
	
}
