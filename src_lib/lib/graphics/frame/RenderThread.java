package lib.graphics.frame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import lib.graphics.panel.GamePanel;

public class RenderThread extends Thread {

	private BufferStrategy bufferStrategy;
	private GamePanel gamePanel;
	
	
	public void setGamePanel(final GamePanel p_gamePanel)
	{
		gamePanel = p_gamePanel;
	}
	
	@Override
	public void run()
	{
		bufferStrategy = gamePanel.getBufferStrategy();
		
		synchRender();
	}
	
	private void synchRender()
	{
		synchronized(bufferStrategy)
		{
			render();
		}
	}
	
	private void render()
	{
		Graphics g = bufferStrategy.getDrawGraphics();
		try
		{
			gamePanel.renderGame(g);
		}
		finally
		{
			g.dispose();
		}
		bufferStrategy.show();
	}
}
