package lib.app;

public class SleepTimeCalculator {

	private static final int DEF_HALF_TIME = 60;
	
	private int sumMsecs;
	private int count;
	private int halfTime;
	
	public SleepTimeCalculator()
	{
		sumMsecs = 0;
		count = 0;
		halfTime = DEF_HALF_TIME;
	}
	
	public void setHalfTime(final int p_halfTime)
	{
		if(p_halfTime <= 0)
			throw new IllegalArgumentException(String.format("HalfTime cannot be zero or negative: %d.", p_halfTime));
		
		halfTime = p_halfTime;
	}
	
	public void add(final int p_msecs)
	{
		sumMsecs += p_msecs;
		if(sumMsecs < 0)
			sumMsecs = 0;
		++count;
		if(count >= halfTime)
		{
			count /= 2;
			sumMsecs /= 2;
		}
	}
	
	public int value()
	{
		return sumMsecs / count;
	}
	
	
	
	
}
