package model;

import java.awt.Graphics;
//import java.util.Random;

import controller.Handler;
import view.Assets;

public class Enemy extends Creature {
	
	private String mode = "alea";

	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.handler = handler;
		bounds.x = 4;
		bounds.y = 34;
		bounds.width = 52;
		bounds.height = 30;
	}

	@Override
	public void tick() {
		getMove(mode);
		move();
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.enemy, (int) (x - handler.getCamera().getxOffSet()), (int) (y - handler.getCamera().getyOffSet()), width, height, null);
	}

	@Override
	public void die() {
		System.out.println("Enemy is dead");
		handler.createEnemy();
	}
	
	// Method that make movements
	private void getMove(String mode) {
		xMove = 0;
		yMove = 0;
		if(mode == "alea") {
			/*x = new Random().nextInt(4);
			if(x == 0){
			    xMove = IAspeed;
			}
			if(x == 1){
			    xMove = -IAspeed;
			}
			if(x == 2){
			    yMove = IAspeed;
			}
			if(x == 3){
			    yMove = -IAspeed;
			}*/
		} else if (mode == "intel") {
			
		}
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
