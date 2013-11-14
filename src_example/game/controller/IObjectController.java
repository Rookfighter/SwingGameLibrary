package game.controller;

import game.entities.IGameObject;
import game.entities.IGameWorld;

public interface IObjectController extends IController {
	
	IGameWorld getWorld();
	void setWorld(final IGameWorld p_gameWorld);
	
	IGameObject getControlledObject();
	void setControlledObject(final IGameObject p_gameObject);
}
