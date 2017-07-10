package model;

import java.awt.Color;
import java.awt.Graphics;
import controller.Handler;
import view.Assets;

public class Player extends Creature {

	protected int health;
	protected int damage;
	protected boolean isIA;
	protected int level; 
	private Handler handler;
	
	// Constructor
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.handler = handler;
		bounds.x = 4;
		bounds.y = 34;
		bounds.width = 60;
		bounds.height = 30;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.player, (int) (x - handler.getCamera().getxOffSet()), (int) (y - handler.getCamera().getyOffSet()), width, height, null);
	}
	
	// Method that make movements from keyManager state
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up)
			yMove = -speed;
		else if(handler.getKeyManager().down)
			yMove = speed;
		else if(handler.getKeyManager().left)
			xMove = -speed;
		else if(handler.getKeyManager().right)
			xMove = speed;
	}
}
