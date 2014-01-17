package lib.app;

import lib.utils.DeltaTime;
import lib.utils.TimeAccount;

public class TimeAccountManager {

	
	private TimeAccount timeAccount;
	private TimeAccount drawTimeAccount;
	
	public TimeAccountManager(final DeltaTime p_deltaTime)
	{
		timeAccount = new TimeAccount(p_deltaTime);
		drawTimeAccount = new TimeAccount(null);
	}
	
	public void increase()
	{
		timeAccount.increase();
	}
	
	public void decrease()
	{
		timeAccount.decrease();
	}
	
	public boolean isOverLimit()
	{
		return timeAccount.isOverLimit();
	}
	
	public TimeAccount getTimeAccount()
	{
		return timeAccount;
	}
	
	public TimeAccount getDrawTimeAccount()
	{
		return drawTimeAccount;
	}
	
	public void assignDrawTimeAccount()
	{
		drawTimeAccount.assign(timeAccount);
	}
}
