package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import controller.Handler;

public abstract class Entity {
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	protected Handler handler;
	protected Rectangle bounds;
	protected boolean active = true;


	public Entity(Handler handler, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	public abstract void render(Graphics graphics);

	public void touch(int i) {
		active = false;
		die();
	}
	
	public abstract void die();
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	// Getters and Setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
