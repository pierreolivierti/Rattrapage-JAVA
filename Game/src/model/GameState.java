package model;

import java.awt.Graphics;

import main.Game;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	// Constructor
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		world = new World("res/world/world.txt");
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics graphics) {
		world.render(graphics);
		player.render(graphics);

	}
	
}
