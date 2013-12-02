package game.view.factories;

import java.awt.BorderLayout;

import game.controller.factories.ControllerFactory;
import game.view.frame.DudeGameFrame;
import game.view.panel.DudeGamePanel;
import lib.graphics.frame.GameFrame;
import lib.graphics.hud.StatusPanel;
import lib.graphics.panel.GamePanel;
import lib.utils.doubl.Dimension2DF;

public class ViewFactory {

	private final ControllerFactory contrFactory;
	private final GameFrame gameFrame;
	private final GamePanel gamePanel;
	private final StatusPanel statusPanel;
	
	public ViewFactory()
	{
		contrFactory = new ControllerFactory();
		gameFrame = new DudeGameFrame();
		gamePanel = new DudeGamePanel(contrFactory.getFieldOfVisionController());
		statusPanel = new StatusPanel();
		initGamePanel();
		initGameFrame();
	}
	
	private void initGamePanel()
	{
		Dimension2DF fovDimension = contrFactory.getFieldOfVisionController().getFieldOfVision().getDimension();
		gamePanel.setPreferredSize(fovDimension);
	}
	
	private void initGameFrame()
	{
		gameFrame.setTitle("Dude Game");
		gameFrame.add(gamePanel, BorderLayout.CENTER);
		gameFrame.add(statusPanel, BorderLayout.LINE_END);
		gameFrame.pack();
	}
	
	public ControllerFactory getControllerFactory()
	{
		return contrFactory;
	}
	
	public GameFrame getGameFrame()
	{
		return gameFrame;
	}
	
	public GamePanel getGamePanel()
	{
		return gamePanel;
	}
	
	public StatusPanel getStatusPanel()
	{
		return statusPanel;
	}
	
}
