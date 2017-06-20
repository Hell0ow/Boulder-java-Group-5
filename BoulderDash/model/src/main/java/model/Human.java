package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.Animation;
import view.Assets;

public class Human extends Character {

	//Animation
	private Animation animDown, animUp, animLeft, animRight, animStart;
	
	public Human(String name, float x, float y) {
		super("Human", x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);
		
		//Animations
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animLeft = new Animation(200, Assets.player_left);
		animRight = new Animation(200, Assets.player_right);
		animStart = new Animation(200, Assets.player_start);

	}
	
	public void tick(){
		
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animStart.tick();
	}
	
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x), (int)(y), width, height, null);

	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if (xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if(yMove > 0){
			return animDown.getCurrentFrame();
		}else{
			return animStart.getCurrentFrame();
		}
	}
	

}
