package lib.app;

import java.util.HashSet;
import java.util.Set;

import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.graphics.IUseTimeAccount;
import lib.utils.DeltaTime;
import lib.utils.TimeAccount;

public abstract class GameThread extends Thread {

	public static final int EXCEPTION_OCCURED = -1;
	
	private volatile boolean stopThread;
	private volatile boolean pausePainting ;
	private volatile boolean pauseLogics;
	
	private SleepTimeCalculator sleepTime;
	
	private Set<IRedrawable> redrawableSet;
	
	private DeltaTime delta;
	private TimeAccount timeAccount;
	
	private int exitStatus;
	private Exception exitException;
	
	public GameThread()
	{
		super();
		stopThread(false);
		pausePainting(false);
		pauseLogic(false);
		
		delta = new DeltaTime();
		timeAccount = new TimeAccount(delta);
		
		sleepTime = new SleepTimeCalculator();
		redrawableSet = new HashSet<IRedrawable>();
	}
	
	public int getExitStatus()
	{
		return exitStatus;
	}
	
	public Exception getException()
	{
		return exitException;
	}
	
	public DeltaTime getDeltaTime()
	{
		return delta;
	}
	
	public void addRedrawable(final IRedrawable p_redrawable)
	{
		if(p_redrawable instanceof IUseDelta)
			((IUseDelta) p_redrawable).setDeltaTime(delta);
		
		if(p_redrawable instanceof IUseTimeAccount)
			((IUseTimeAccount) p_redrawable).setTimeAccount(timeAccount);
			
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
	
	public void stopThread(boolean p_stop)
	{
		stopThread = p_stop;
	}
	
	public void pauseLogic(boolean p_pause)
	{
		pauseLogics = p_pause;
	}
	
	public void pausePainting(boolean p_pause)
	{
		pausePainting = p_pause;
	}
	
	@Override
	public void run()
	{
		initExitStatus();
		
		try
		{
			runGame();
		}
		catch (Exception e)
		{
			exitException = e;
			exitStatus = EXCEPTION_OCCURED;
		}
		System.out.println("Thread terminated.");
	}
	
	private void initExitStatus()
	{
		exitStatus = 0;
		exitException = null;
	}
	
	private void runGame() throws InterruptedException
	{
		//for initialization
		//else last = 0 and current = XXXXX -> big time diff
		catchTime();
		while(!stopThread) 
		{
			catchTime();
			executeLogicsIfNotPaused();
			redrawIfNotPaused();
			//sleep(sleepTime.value());
		}
	}
	
	private void catchTime()
	{
		delta.catchTime();
		sleepTime.add(timeAccount.getStepMilli() - delta.getMilli());
	}
	
	private void executeLogicsIfNotPaused()
	{
		if(!pauseLogics)
			executeLogicsInTime();
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
	
	private void redrawIfNotPaused()
	{
		if(!pausePainting)
			redraw();
	}
	
	private void redraw()
	{
		for(IRedrawable redrawable : redrawableSet)
			redrawable.redraw();
	}
	
}
