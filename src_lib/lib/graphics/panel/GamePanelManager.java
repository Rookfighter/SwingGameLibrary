package lib.graphics.panel;

import java.util.ArrayList;
import java.util.List;

import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.graphics.IUseTimeAccount;
import lib.graphics.frame.DrawThread;
import lib.utils.DeltaTime;
import lib.utils.TimeAccount;

public class GamePanelManager implements IRedrawable, IUseDelta, IUseTimeAccount{

	private TimeAccount globalTimeAccount;
	private DeltaTime globalDeltaTime;
	
	private List<GamePanel> gamePanels;
	private List<DeltaTime> drawDeltaTimes;
	private List<TimeAccount> drawTimeAccounts;
	private List<DrawThread> drawThreads;
	
	public GamePanelManager()
	{
		drawDeltaTimes = new ArrayList<DeltaTime>();
		drawTimeAccounts = new ArrayList<TimeAccount>();
		drawThreads = new ArrayList<DrawThread>();
		gamePanels = new ArrayList<GamePanel>();
	}
	
	@Override
	public void setTimeAccount(TimeAccount p_account)
	{
		globalTimeAccount = p_account;
	}

	@Override
	public void setDeltaTime(DeltaTime p_delta)
	{
		globalDeltaTime = p_delta;
	}
	
	@Override
	public TimeAccount getTimeAccount()
	{
		return globalTimeAccount;
	}

	@Override
	public DeltaTime getDeltaTime()
	{
		return globalDeltaTime;
	}
	
	public void add(final GamePanel p_panel)
	{
		gamePanels.add(p_panel);
		
		DeltaTime delta = new DeltaTime();
		TimeAccount account = new TimeAccount(null);
	
		p_panel.setDeltaTime(delta);
		p_panel.setTimeAccount(account);
		
		drawDeltaTimes.add(delta);
		drawTimeAccounts.add(account);
	}

	@Override
	public void redraw()
	{
		joinThreads();
		assignDeltaTimes();
		assignTimeAccounts();
		generatePaintLists();
		createThreads();
		startThreads();
	}
	
	private void joinThreads()
	{
		try
		{
			for(Thread thread : drawThreads)
				thread.join();
		}
		catch (Exception e)
		{
			System.out.printf("%s: Could not join thread: %s \n", e.getClass().getName(), e.getMessage());
		}
	}
	
	private void assignDeltaTimes()
	{
		for(DeltaTime delta : drawDeltaTimes)
		{
			synchronized(delta)
			{
				delta.assign(globalDeltaTime);
			}
		}
	}
	
	private void assignTimeAccounts()
	{
		for(TimeAccount account : drawTimeAccounts)
		{
			synchronized(account)
			{
				account.assign(globalTimeAccount);
			}
		}
	}
	
	private void generatePaintLists()
	{
		for(GamePanel panel : gamePanels)
			panel.generatePaintlist();
	}
	
	private void createThreads()
	{
		drawThreads.clear();
		DrawThread thread;
		for(int i = 0; i < gamePanels.size(); i++)
		{
			thread = new DrawThread();
			thread.setGamePanel(gamePanels.get(i));
			drawThreads.add(thread);
		}
	}
	
	private void startThreads()
	{
		for(Thread thread: drawThreads)
			thread.start();
	}

}
