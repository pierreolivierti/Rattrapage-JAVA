package model;

import java.awt.Graphics;

import view.Assets;

public class Player extends Entity {

	protected int health;
	protected int speed;
	protected int damage;
	protected boolean isIA;
	protected int level; 
	
	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.player, 15, 15, null);
	}	
}
