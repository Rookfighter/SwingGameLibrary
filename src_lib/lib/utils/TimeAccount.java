package lib.utils;

public class TimeAccount {
	
	private static final int THOUSAND = 1000;
	
	private int timeStep; //milliseconds
	private double fps;
	private int timeAccount; //milliseconds
	private DeltaTime deltaTime;
	
	public TimeAccount(final DeltaTime p_deltaTime)
	{
		timeAccount = 0;
		setFPSLimit(60.0);
		deltaTime = p_deltaTime;
	}
	
	public boolean isOverLimit()
	{
		return timeAccount > timeStep;
	}
	
	public void decrease()
	{
		timeAccount -= timeStep;
	}
	
	public void increase()
	{
		timeAccount += deltaTime.getMilli();
	}
	
	public void setFPSLimit(final double p_fps)
	{
		if(p_fps <= 0)
			throw new IllegalArgumentException(String.format("FPS cannot be zero or lower, is: %.2f.", p_fps));
		fps = p_fps;
		timeStep = (int) ((1 / fps) * THOUSAND);
	}
	
	public double getFPSLimit()
	{
		return fps;
	}
	
	public void setStepMilli(final int p_step)
	{
		if(p_step <= 0)
			throw new IllegalArgumentException(String.format("Timestep cannot be zero or lower, is: %d.", p_step));
		timeStep = p_step;
		fps = (double) (p_step / THOUSAND);
	}
	
	public int getStepMilli()
	{
		return timeStep;
	}
	

}
