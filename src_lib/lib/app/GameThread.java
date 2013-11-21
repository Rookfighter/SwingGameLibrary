package lib.app;

import javax.swing.JOptionPane;

import lib.graphics.panel.GamePanel;
import lib.utils.TimeAccount;

public abstract class GameThread extends Thread {
	
	public volatile boolean runGame = true;
	
	//in microseconds
	private static final int MIN_SLEEPTIME = 1;
	private int sleepMsecs;
	
	private GamePanel gamePanel;
	private DeltaTimeManager deltaManager;
	private TimeAccount timeAccount;
	
	public GameThread()
	{
		super();
		deltaManager = new DeltaTimeManager();
		timeAccount = new TimeAccount(deltaManager.getDeltaTime());
		sleepMsecs = timeAccount.getStepMilli() / 2;
	}
	
	public DeltaTimeManager getDeltaTimeManager()
	{
		return deltaManager;
	}
	
	public void setGamePanel(final GamePanel p_gamePanel)
	{
		gamePanel = p_gamePanel;
		gamePanel.setDeltaTime(deltaManager.getDrawDeltaTime());
	}
	
	@Override
	public void run()
	{
		try
		{
			runGame();
		}
		catch ( Exception e)
		{
			String msg = String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
			JOptionPane.showMessageDialog(gamePanel, msg, e.getClass().getSimpleName() , JOptionPane.OK_OPTION);
			System.out.println(msg);
		}
		System.out.println("Thread terminated.");
	}
	
	
	private void runGame() throws InterruptedException
	{
		//for initialization
		//else last = 0 and current = XXXXX -> big time diff
		catchTime();
		while(runGame) 
		{
			catchTime();
			executeLogicsInTime();
			paint();
			sleep(sleepMsecs);
		}
	}
	
	private void catchTime()
	{
		deltaManager.catchTime();
		sleepMsecs += timeAccount.getStepMilli() - deltaManager.getDeltaTime().getMilli();
		if(sleepMsecs <= 0)
			sleepMsecs = MIN_SLEEPTIME;
		System.out.println(deltaManager.getDeltaTime().getFPS());
	}
	
	private void executeLogicsInTime()
	{
		timeAccount.increase();
		while(timeAccount.isOverLimit())
		{
			executeLogics();
			timeAccount.decrease();
		}
	}
	
	//to implement
	protected abstract void executeLogics();
	
	private void paint()
	{
		synchronizeDeltaTimes();
		gamePanel.generatePaintlist();
		gamePanel.render();
	}
	
	private void synchronizeDeltaTimes()
	{
		synchronized(deltaManager.getDrawDeltaTime())
		{
			deltaManager.assignDrawDeltaTime();
		}
	}
	
	

}
