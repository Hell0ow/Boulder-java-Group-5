package model;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import Imodel.IElement;

public class Element implements IElement {
	private String name;
	
	protected static int width = 16, height = 16;

	protected BufferedImage sheet;
	
	public Element(String name, String path, Coordinates c) throws Exception {
		this.name = name;
		
		sheet = ImageIO.read(new FileInputStream(path));
		sheet = sheet.getSubimage(c.getX(), c.getY(), width, height);
	}
	
	public String getName() {
		return name;
	}
	
	public BufferedImage getSheet() {
		return sheet;
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
}
