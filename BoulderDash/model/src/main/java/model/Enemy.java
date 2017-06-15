package model;

public class Enemy extends Character {
	private NPC npc;
	
	public Enemy(NPC npc, Position position) {
		super(position);
		
		this.npc = npc;
	}
	
	public NPC getNPC() {
		return npc;
	}
}
