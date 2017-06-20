package model;

import java.awt.image.BufferedImage;


public abstract class Character extends Element {
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CHARACTER_WIDTH = 64,
							DEFAULT_CHARACTER_HEIGHT = 64;
	
	
	protected float speed;
	protected float xMove, yMove;
	
	public Character(String name, float x, float y, int width, int height) {
		super(name, null);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	
	}
	
	//Getters and Setters
	
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
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}


}
