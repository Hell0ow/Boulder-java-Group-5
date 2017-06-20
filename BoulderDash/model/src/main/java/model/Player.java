package model;

public class Player {
	private Integer id;
	private String name;
	
	public Player(Integer id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return new String(name);
	}
}
