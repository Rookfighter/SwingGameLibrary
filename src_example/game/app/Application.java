package game.app;

import javax.swing.JOptionPane;

import lib.app.GameThread;
import lib.graphics.frame.GameFrame;
import game.app.factories.GameFactory;
import game.audio.music.BackgroundMusic;
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
		app.waitForThread();
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
		BackgroundMusic.getInstance().start();
	}
	
	private void waitForThread()
	{
		try
		{
			gameFactory.getGameThread().join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		if(gameFactory.getGameThread().getExitStatus() == GameThread.EXCEPTION_OCCURED)
		{
			Exception e = gameFactory.getGameThread().getException();
			String msg = String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
			JOptionPane.showMessageDialog(gameFactory.getViewFactory().getGameFrame(), msg, e.getClass().getSimpleName() , JOptionPane.OK_OPTION);
			System.out.println(msg);
		}
			
	}
}
