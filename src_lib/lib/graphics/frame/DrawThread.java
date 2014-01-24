package lib.graphics.frame;

import java.awt.image.BufferStrategy;

import lib.graphics.panel.GamePanel;

public class DrawThread extends Thread {

	private BufferStrategy bufferStrategy;
	private GamePanel gamePanel;
	
	
	public void setGamePanel(final GamePanel p_gamePanel)
	{
		gamePanel = p_gamePanel;
	}
	
	@Override
	public void run()
	{
		gamePanel.setBufferStrategy();
		bufferStrategy = gamePanel.getBufferStrategy();
		synchDraw();
	}
	
	private void synchDraw()
	{
		synchronized(bufferStrategy)
		{
			synchronized(gamePanel.getDeltaTime())
			{
				synchronized(gamePanel.getTimeAccount())
				{
					draw();
				}
			}
			
		}
	}
	
	private void draw()
	{
		gamePanel.redraw();
	}
}
