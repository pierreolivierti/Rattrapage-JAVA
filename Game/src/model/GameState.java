package model;

import java.awt.Graphics;

import controller.Handler;;

public class GameState extends State {
	
	private World world;
	
	// Constructor
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/world/world.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics graphics) {
		world.render(graphics);
	}
}
