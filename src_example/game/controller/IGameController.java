package game.controller;

import game.entities.IGameWorld;

import java.util.List;

public interface IGameController {
	
	IGameWorld getWorld();
	void setWorld(final IGameWorld p_gameWorld);
	
	IFieldOfVisionController getFieldOfVisionController();
	
	List<IController> getControllerList();
	void setControllerList(final List<IController> p_controllerList);
	
	void AddController(final IController p_controller);
	void RemoveController(final IController p_controller);
	void ClearControllerList();
	
	void executeLogics();
	
}
