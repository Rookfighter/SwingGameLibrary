package game.controller.classes;

import java.util.LinkedList;
import java.util.List;

import game.controller.IController;
import game.controller.IFieldOfVisionController;
import game.controller.IGameController;
import game.entities.IGameWorld;

public class GameController implements IGameController {

	private IGameWorld gameWorld;
	private IFieldOfVisionController fovController;
	private List<IController> controllerList;
	
	public GameController()
	{
		this(null);
	}
	
	public GameController(final IGameWorld p_gameWorld)
	{
		controllerList = new LinkedList<IController>();
		gameWorld = p_gameWorld;
	}
	
	@Override
	public IGameWorld getWorld()
	{
		return gameWorld;
	}

	@Override
	public void setWorld(IGameWorld p_gameWorld)
	{
		gameWorld = p_gameWorld;
	}

	@Override
	public IFieldOfVisionController getFieldOfVisionController()
	{
		return fovController;
	}

	@Override
	public List<IController> getControllerList()
	{
		return controllerList;
	}

	@Override
	public void setControllerList(List<IController> p_controllerList)
	{
		controllerList.clear();
		controllerList.addAll(p_controllerList);
	}

	@Override
	public void AddController(IController p_controller)
	{
		if(p_controller instanceof IFieldOfVisionController)
			addFieldOfVisionController((IFieldOfVisionController) p_controller);
		controllerList.add(p_controller);
		
	}
	
	private void addFieldOfVisionController(final IFieldOfVisionController p_fovController)
	{
		if (fovController != null)
			throw new IllegalArgumentException("Cannot add FieldOfVision to GameController. Already assigned.");
		fovController = p_fovController;
	}

	@Override
	public void RemoveController(IController p_controller)
	{
		if(controllerList.remove(p_controller) && p_controller instanceof IFieldOfVisionController)
			fovController = null;
	}

	@Override
	public void ClearControllerList()
	{
		controllerList.clear();
	}

	@Override
	public void executeLogics() {
		for(IController controller : controllerList)
			controller.doLogics();
	}

}
