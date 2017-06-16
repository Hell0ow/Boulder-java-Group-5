package model;

public class Element {
	private String name;
	public char texture; /*TEMP*/
	
	public Element(String name, char texture) {
		this.name = name;
		this.texture = texture;
	}
	
	public String getName() {
		return name;
	}
}
