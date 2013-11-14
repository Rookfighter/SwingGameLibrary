package game.app.factories;

import lib.app.GameThread;
import game.app.DudeGameThread;
import game.view.factories.ViewFactory;

public class GameFactory {

	private final ViewFactory viewFactory;
	private final DudeGameThread gameThread;
	
	public GameFactory()
	{
		viewFactory = new ViewFactory();
		gameThread = new DudeGameThread();
		initGameThread();
	}
	
	private void initGameThread()
	{
		gameThread.setGameController(viewFactory.getControllerFactory().getGameController());
		gameThread.setGamePanel(viewFactory.getGamePanel());
		gameThread.setPriority(Thread.MAX_PRIORITY);
	}
	
	public ViewFactory getViewFactory()
	{
		return viewFactory;
	}
	
	public GameThread getGameThread()
	{
		return gameThread;
	}
}
