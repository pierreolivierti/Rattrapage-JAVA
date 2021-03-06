package model;

import controller.Handler;

public abstract class Creature extends Entity {
	public static final int DEFAULT_HEALTH = 80;
	public static final int DEFAULT_DAMAGE = 40;
	public static final float DEFAULT_SPEED = 10.0f;
	public static final float DEFAULT_IA_SPEED = 1.0f;
	public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;
	protected int health;
	protected int damage;
	protected float speed;
	protected float IAspeed;
	protected float xMove;
	protected float yMove;
	
	// Constructor
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.damage = DEFAULT_DAMAGE;
		this.speed = DEFAULT_SPEED;
		this.IAspeed = DEFAULT_IA_SPEED;
		xMove = 0;
		yMove = 0;
	}
	 
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void moveX() {
		// Right move
		if(xMove > 0) {				
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			
			if(!collisionTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
		// Left move
		} else if(xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			
			if(!collisionTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
	}
	
	public void moveY() {
		// Up move
		if(yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			
			if(!collisionTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
		// Down move
		} else if(yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			
			if(!collisionTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	// Getters and Setters
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
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
