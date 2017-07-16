package model;

import java.awt.Graphics;
import java.awt.Rectangle;

import controller.Handler;
import view.Assets;

public class Player extends Creature {

	protected int health;
	protected int damage;
	protected boolean isIA;
	protected int level; 
	private Handler handler;
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	// Constructor
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.handler = handler;
		bounds.x = 4;
		bounds.y = 34;
		bounds.width = 52;
		bounds.height = 30;
	}

	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 50;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.touch(1);
				return;
			}
		}
		
	}
	
	@Override
	public void tick() {
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
		checkAttacks();
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

	@Override
	public void die() {
		System.out.println("Player is dead");
	}
}
