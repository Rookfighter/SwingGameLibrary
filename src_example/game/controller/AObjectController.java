package game.controller;

import game.entities.IGameObject;
import game.entities.IGameWorld;

public abstract class AObjectController implements IObjectController {

	private IGameWorld world;
	private IGameObject gameObject;
	
	public AObjectController(final IGameObject p_gameObject, final IGameWorld p_gameWorld)
	{
		world = p_gameWorld;
		gameObject = p_gameObject;
	}
	
	@Override
	public IGameWorld getWorld()
	{
		return world;
	}

	@Override
	public void setWorld(IGameWorld p_gameWorld)
	{
		world = p_gameWorld;
	}

	@Override
	public IGameObject getControlledObject() {
		return gameObject;
	}

	@Override
	public void setControlledObject(IGameObject p_gameObject)
	{
		gameObject = p_gameObject;
	}

}
