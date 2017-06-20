package model;

import java.awt.image.BufferedImage;

public class Element {
	private String name;
	public BufferedImage texture; /*TEMP*/
	
	protected int width, height;
	protected float x, y;
	
	public Element(String name, BufferedImage texture) {
		this.name = name;
		this.texture = texture;
	}
	
	public String getName() {
		return name;
	}

	public BufferedImage getTexture() {
		return texture;
	}
	
	
}
