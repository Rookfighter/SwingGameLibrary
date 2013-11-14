package game.app;

import lib.graphics.frame.GameFrame;
import game.app.factories.GameFactory;
import game.audio.music.SoundLoader;
import game.view.sprites.GameSpriteSheetLoader;


public final class Application {

	private final GameFactory gameFactory;
	private final GameFrame gameFrame;
	
	private Application()
	{
		gameFactory = new GameFactory();
		gameFrame = gameFactory.getViewFactory().getGameFrame();
	}
	
	public static void main(String[] args)
	{
		Application app = new Application();
		app.initializeGame();
	}
	
	private void initializeGame()
	{
		initializeController();
		initializeGameFrame();
		gameFactory.getGameThread().start();
	}
	
	private void initializeController()
	{
		gameFactory.getViewFactory().getControllerFactory().createSimpleDudeController().getControlledObject().getPosition().set(200,200);
		gameFactory.getViewFactory().getControllerFactory().createSimpleDudeController().getControlledObject().getPosition().set(500,400);
	}
	
	private void initializeGameFrame()
	{
		gameFrame.setVisible(true);
		gameFrame.setSpriteSheetLoader(new GameSpriteSheetLoader());
		gameFrame.setSoundLoader(new SoundLoader());
		gameFrame.loadSpriteSheets();
		gameFrame.loadSounds();
	}
}
