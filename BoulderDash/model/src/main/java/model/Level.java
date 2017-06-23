package model;
import java.util.HashMap;
import java.util.Map;import Imodel.IBlock;import Imodel.ICharacter;import Imodel.IHero;import Imodel.ILevel;import Imodel.IModel;import Imodel.IObjective;import Imodel.ITile;import Imodel.ITray;
public class Level implements ILevel {
	private Map<String, IBlock> blocks = new HashMap<String, IBlock>();
	private Map<String, ICharacter> characters = new HashMap<String, ICharacter>();
	private Model model;
	private Objective objective;
	private Tray tray;
	public Level(Model model) throws Exception {		this.model = model;				//TEMP				setObjective((IObjective) new Objective((Player) model.getPlayer(), 25));						//TEMP				tray = new Tray(this, 0);						//tray.addEnemy(new Enemy((Dummy) characters.get("Dummy"), Direction.LEFT, new Position(tray, 3, 3)));	}
	public Map<String, IBlock> getBlocks() {
		return blocks;
	}
	public void addBlock(IBlock block) {
		blocks.put(block.getName(), block);
	}
	public Map<String, ICharacter> getCharacters() {
		return characters;
	}
	public void addCharacter(ICharacter character) {
		characters.put(character.getName(), character);
	}
	public IObjective getObjective() {
		return (IObjective) objective;
	}
	public void setObjective(IObjective objective) {
		this.objective = (Objective) objective;
	}		public IModel getModel() {		return (IModel) model;	}
	public ITray getTray() {
		return (ITray) tray;
	}
}
