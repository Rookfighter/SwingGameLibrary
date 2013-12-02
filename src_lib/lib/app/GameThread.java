package lib.app;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.utils.TimeAccount;

public abstract class GameThread extends Thread {
	
	public volatile boolean runGame = true;
	
	//in microseconds
	private static final int MIN_SLEEPTIME = 1;
	private int sleepMsecs;
	
	private Set<IRedrawable> redrawableSet;
	
	private DeltaTimeManager deltaManager;
	private TimeAccount timeAccount;
	
	public GameThread()
	{
		super();
		deltaManager = new DeltaTimeManager();
		timeAccount = new TimeAccount(deltaManager.getDeltaTime());
		sleepMsecs = timeAccount.getStepMilli() / 2;
		redrawableSet = new HashSet<IRedrawable>();
	}
	
	public DeltaTimeManager getDeltaTimeManager()
	{
		return deltaManager;
	}
	
	public void addRedrawable(final IRedrawable p_redrawable)
	{
		if(p_redrawable instanceof IUseDelta)
			((IUseDelta) p_redrawable).setDeltaTime(deltaManager.getDrawDeltaTime());
		redrawableSet.add(p_redrawable);
	}
	
	public boolean removeRedrawable(final IRedrawable p_redrawable)
	{
		return redrawableSet.remove(p_redrawable);
	}
	
	public void clearRedrawables()
	{
		redrawableSet.clear();
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
			JOptionPane.showMessageDialog(null, msg, e.getClass().getSimpleName() , JOptionPane.OK_OPTION);
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
			redraw();
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
	
	private void redraw()
	{
		synchronizeDeltaTimes();
		for(IRedrawable redrawable : redrawableSet)
			redrawable.redraw();
	}
	
	private void synchronizeDeltaTimes()
	{
		synchronized(deltaManager.getDrawDeltaTime())
		{
			deltaManager.assignDrawDeltaTime();
		}
	}
	
	

}
