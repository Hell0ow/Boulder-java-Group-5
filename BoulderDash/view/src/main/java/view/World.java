package view;

import java.awt.Graphics;

import model.Model;
import model.Position;

public class World {
	
	private Position positionMax, p;
	private Model model;
	private int width, height;
	
	
	public World(Model model){
		this.model = model;	
		
		loadWorld();
		
	}
	
	public void loadWorld(){
		
		try {
			p = model.getLevel().getTray().getBoundary().getMinPosition();
			positionMax = model.getLevel().getTray().getBoundary().getMaxPosition();
		
			for (; !p.equals(positionMax); p.next()) {
				model.getLevel().getTray().getTiles().get(p).getBlock().getTexture();
			}
			model.getLevel().getTray().getTiles().get(p).getBlock().getTexture();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        }
	
	public void render(Graphics g){
		try {
			for(; !p.equals(positionMax); p.next())
			g.drawImage(model.getLevel().getTray().getTiles().get(p).getBlock().getTexture(), width, height, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
