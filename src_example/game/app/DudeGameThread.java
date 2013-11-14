package game.app;

import lib.app.GameThread;
import game.controller.IGameController;

public class DudeGameThread extends GameThread {

	private IGameController gameController;
	
	public void setGameController(final IGameController p_controller)
	{
		gameController = p_controller;
	}
	
	public IGameController getGameController()
	{
		return gameController;
	}
	
	@Override
	protected void executeLogics()
	{
		gameController.executeLogics();
	}

}
