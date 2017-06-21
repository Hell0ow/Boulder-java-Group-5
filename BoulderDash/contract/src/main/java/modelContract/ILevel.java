package modelContract;

import java.util.Map;

public interface ILevel {

	public Map<String, IBlock> getBlocks();
	
	public void addBlock(IBlock block);
	
	public Map<String, ICharacter> getCharacters();
	
	public void addCharacter(ICharacter character);
	
	public IObjective getObjective();
	
	public void setObjective(IObjective objective);
	
	public ITray getTray();
}
