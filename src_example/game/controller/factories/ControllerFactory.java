package game.controller.factories;

import game.controller.IFieldOfVisionController;
import game.controller.IGameController;
import game.controller.classes.FieldOfVisionController;
import game.controller.classes.GameController;
import game.controller.classes.SimpleDudeController;
import game.entities.classes.FieldOfVision;
import game.entities.factories.GameObjectFactory;

public class ControllerFactory {

	private final GameObjectFactory objectFactory;
	private final IGameController gameController;
	private final IFieldOfVisionController fovController;
	
	public ControllerFactory()
	{
		objectFactory = new GameObjectFactory();
		gameController = new GameController();
		fovController = new FieldOfVisionController();
		initFoVController();
		initGameController();
	}
	
	private void initGameController()
	{
		gameController.setWorld(objectFactory.getWorld());
		gameController.AddController(fovController);
	}
	
	private void initFoVController()
	{
		fovController.setGameWorld(objectFactory.getWorld());
		fovController.setFieldOfVision(new FieldOfVision());
		fovController.getFieldOfVision().getDimension().set(800,600);
		fovController.getFieldOfVision().getPosition().set(400,300);
		fovController.getInFovBuffer().set(1000, 800);
	}
	
	public IGameController getGameController()
	{
		return gameController;
	}
	
	public IFieldOfVisionController getFieldOfVisionController()
	{
		return fovController;
	}
	
	public SimpleDudeController createSimpleDudeController()
	{
		SimpleDudeController dudeController = new SimpleDudeController();
		dudeController.setControlledObject(objectFactory.createSimpleDude());
		dudeController.setWorld(objectFactory.getWorld());
		gameController.AddController(dudeController);
		return dudeController;
	}
}
