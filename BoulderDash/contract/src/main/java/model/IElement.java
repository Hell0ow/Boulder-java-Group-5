package model;

import java.awt.image.BufferedImage;

public interface IElement {

	public String getName();
	
	public BufferedImage getSheet();
	
	public int getWidth();
	
	public int getHeight();
}
