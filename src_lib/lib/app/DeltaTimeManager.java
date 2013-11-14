package lib.app;

import lib.utils.DeltaTime;

public class DeltaTimeManager {
	
	private DeltaTime logicDeltaTime;
	private DeltaTime drawDeltaTime;
	
	public DeltaTimeManager()
	{
		logicDeltaTime = new DeltaTime();
		drawDeltaTime = new DeltaTime();
	}
	
	public DeltaTime getDeltaTime()
	{	
		return logicDeltaTime;
	}
	
	public DeltaTime getDrawDeltaTime()
	{		
		return drawDeltaTime;
	}
	
	public void assignDrawDeltaTime()
	{
		drawDeltaTime.assign(logicDeltaTime);
	}
	
	public void catchTime()
	{
		logicDeltaTime.catchTime();
	}


}
