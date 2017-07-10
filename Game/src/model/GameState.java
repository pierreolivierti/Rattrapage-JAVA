package model;

import java.awt.Graphics;

import controller.Handler;;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	// Constructor
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/world/world.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
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
