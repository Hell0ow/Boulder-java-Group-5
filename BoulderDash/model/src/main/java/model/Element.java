package model;

public class Element {
	private String name;
	public char texture = '*'; /*TEMP*/
	
	public Element(String name) {
		this.name = new String(name);
	}
	
	public String getName() {
		return name;
	}
}
