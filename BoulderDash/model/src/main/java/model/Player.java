package model;

public class Player {
	private Integer id;
	private Hero hero = null;
	private Objective objective = null;
	private String name;
	
	Player(Integer id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Objective getObjective() {
		return new Objective(objective);
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}
	
	public String getName() {
		return new String(name);
	}
}
