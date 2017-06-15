package model;

public class Objective {
	private int obtained;
	private int required;
	
	public Objective(int required) {
		this.required = required;
		obtained = 0;
	}
	
	public Objective(Objective objective) {
		required = objective.required;
		obtained = objective.obtained;
	}
	
	public boolean isCompleted() {
		return obtained >= required;
	}
	
	public int getObtained() {
		return obtained; 
	}
	
	public void setObtained(int obtained) {
		this.obtained = obtained;
	}
	
	public int getRequired() {
		return required;
	}
}
