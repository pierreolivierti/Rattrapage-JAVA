package model;

import java.awt.Graphics;

public abstract class Creature extends Entity {
	public static final int DEFAULT_HEALTH = 80;
	public static final int DEFAULT_DAMAGE = 40;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
	private int health;
	private int damage;
	private float speed;
	private float xMove;
	private float yMove;
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.damage = DEFAULT_DAMAGE;
		this.speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics graphics) {
		
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
