package game.view.factories;

import java.awt.BorderLayout;

import game.controller.factories.ControllerFactory;
import game.view.controls.FovControl;
import game.view.frame.DudeGameFrame;
import game.view.panel.DudeGamePanel;
import lib.graphics.components.StatusPanel;
import lib.graphics.frame.GameFrame;
import lib.graphics.panel.GamePanel;
import lib.graphics.panel.GamePanelManager;
import lib.utils.doubl.Dimension2DF;

public class ViewFactory {

	private final ControllerFactory contrFactory;
	private final GameFrame gameFrame;
	private final GamePanel gamePanel;
	private final GamePanelManager gamePanelManager;
	private final StatusPanel statusPanel;
	private final FovControl fovControl;
	
	public ViewFactory()
	{
		contrFactory = new ControllerFactory();
		gameFrame = new DudeGameFrame();
		gamePanel = new DudeGamePanel(contrFactory.getFieldOfVisionController());
		gamePanelManager = new GamePanelManager();
		statusPanel = new StatusPanel();
		fovControl = new FovControl();
		initGamePanel();
		initGamePanelManager();
		initFovControl();
		initGameFrame();
	}
	
	private void initGamePanel()
	{
		Dimension2DF fovDimension = contrFactory.getFieldOfVisionController().getFieldOfVision().getDimension();
		gamePanel.setPreferredSize(fovDimension);
	}
	
	private void initGamePanelManager()
	{
		gamePanelManager.add(gamePanel);
	}
	
	private void initFovControl()
	{
		fovControl.setFovController(contrFactory.getFieldOfVisionController());
	}
	
	private void initGameFrame()
	{
		gameFrame.setTitle("Dude Game");
		gameFrame.add(gamePanel, BorderLayout.CENTER);
		gameFrame.add(statusPanel, BorderLayout.LINE_END);
		gameFrame.setKeyControl(fovControl);
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
	
	public GamePanelManager getGamePanelManager()
	{
		return gamePanelManager;
	}
	
}
