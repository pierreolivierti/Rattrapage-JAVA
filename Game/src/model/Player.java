package model;

import java.awt.Graphics;

import main.Game;
import view.Assets;

public class Player extends Creature {

	protected int health;
	protected int speed;
	protected int damage;
	protected boolean isIA;
	protected int level; 
	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up)
			y -= 3;
		else if(game.getKeyManager().down)
			y += 3;
		else if(game.getKeyManager().left)
			x -= 3;
		else if(game.getKeyManager().right)
			x += 3;
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}	
}
