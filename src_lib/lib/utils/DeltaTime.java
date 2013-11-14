package lib.utils;

public class DeltaTime {
	
	private int current; //milliseconds
	private int last; //milliseconds
	private int delta; //milliseconds
	private double fps;

	private static final int THOUSAND = 1000;
	private static final int MILLION = 1000000;
	
	public DeltaTime()
	{
		current = 0;
		last = 0;
		delta = 0;
	}
	
	public void catchTime()
	{
		setNextTime((int)(System.nanoTime() / MILLION));
	}
	
	public void setNextTime(final int p_next)
	{
		if( p_next < current )
			throw new IllegalArgumentException(String.format("New delta timestamp (%d) is lower than last one (%d).",
															 p_next, current));
		last = current;
		current = p_next;
		delta = current - last;
		
		fps = (double) delta;
		fps = 1 / (fps / THOUSAND);
	}
	
	public int getMilli()
	{
		return delta;
	}
	
	public double getFPS()
	{
		return fps;
	}
	
	public void assign(final DeltaTime p_delta)
	{
		current = p_delta.current;
		last = p_delta.last;
		delta = p_delta.delta;
	}

}
