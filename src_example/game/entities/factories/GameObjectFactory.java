package game.entities.factories;

import game.entities.IGameWorld;
import game.entities.classes.SimpleDude;
import game.entities.classes.SimpleWorld;

public class GameObjectFactory {

	private final IGameWorld gameWorld;
	
	public GameObjectFactory()
	{
		gameWorld = new SimpleWorld();
	}
	
	public IGameWorld getWorld()
	{
		return gameWorld;
	}
	
	public SimpleDude createSimpleDude()
	{
		SimpleDude dude = new SimpleDude();
		gameWorld.addObject(dude);
		return dude;
	}
	
}
