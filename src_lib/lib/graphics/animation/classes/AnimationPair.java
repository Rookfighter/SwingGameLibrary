package lib.graphics.animation.classes;

import lib.graphics.sprites.ISprite;

public class AnimationPair {

	private static final int THOUSAND = 1000;
	
	private ISprite sprite;
	private int msecs;
	private double seconds;
	
	public AnimationPair()
	{
		sprite = null;
		msecs = THOUSAND;
	}
	
	public void set(final ISprite p_sprite, final int p_msec)
	{
		setSprite(p_sprite);
		setMicroSeconds(p_msec);
	}
	
	public void setMicroSeconds(final int p_msec)
	{
		if(p_msec <= 0)
			throw new IllegalArgumentException(String.format("Animation sprite time cannot be negative or zero. Is %dusec.", p_msec));
		msecs = p_msec;
		seconds = msecs / THOUSAND;
	}
	
	public void setSeconds(final double p_seconds)
	{
		seconds = p_seconds;
		msecs = (int) seconds * THOUSAND;
	}
	
	public void setSprite(final ISprite p_sprite)
	{
		sprite = p_sprite;
	}
	
	public double getSeconds()
	{
		return seconds;
	}
	
	public int getMilliSeconds()
	{
		return msecs;
	}
	
	public ISprite getSprite()
	{
		return sprite;
	}
	
	public void assign(final AnimationPair p_pair)
	{
		msecs = p_pair.msecs;
		sprite = p_pair.sprite;
	}
	
}
