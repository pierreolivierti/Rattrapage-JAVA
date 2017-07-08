package model;

import java.awt.Graphics;

import main.Game;
import view.Assets;

public class Player extends Creature {

	protected int health;
	protected int damage;
	protected boolean isIA;
	protected int level; 
	private Game game;
	
	// Constructor
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}
	
	// Method that make movements from keyManager state
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(game.getKeyManager().up)
			yMove = -speed;
		else if(game.getKeyManager().down)
			yMove = speed;
		else if(game.getKeyManager().left)
			xMove = -speed;
		else if(game.getKeyManager().right)
			xMove = speed;
	}
}
