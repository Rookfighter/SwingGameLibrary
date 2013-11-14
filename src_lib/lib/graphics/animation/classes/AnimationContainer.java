package lib.graphics.animation.classes;

import java.util.ArrayList;
import java.util.List;

import lib.graphics.sprites.ISprite;

public class AnimationContainer {

	private List<AnimationPair> animationPairs;
	private List<Integer> elapsedMsecs;
	
	private int msecs;
	private double seconds;
	
	public AnimationContainer()
	{
		animationPairs = new ArrayList<AnimationPair>();
		elapsedMsecs = new ArrayList<Integer>();
	}

	public void set(final List<AnimationPair> p_pairs)
	{
		animationPairs.clear();
		animationPairs.addAll(p_pairs);
		calculateTime();
	}
	
	public void setSize(final int p_size)
	{
		animationPairs = new ArrayList<AnimationPair>(p_size);
		for(int i = 0; i < p_size; ++i)
			animationPairs.add(new AnimationPair());
	}
	
	public void clear()
	{
		animationPairs.clear();
		calculateTime();
	}
	
	public void calculateTime()
	{
		msecs = 0;
		seconds = 0;
		elapsedMsecs= new ArrayList<Integer>(animationPairs.size());

		for(int i = 0; i < animationPairs.size(); ++i)
		{
			elapsedMsecs.add(msecs);
			
			AnimationPair pair = get(i);
			msecs += pair.getMilliSeconds();
			seconds += pair.getSeconds();
		}
	}
	
	public AnimationPair get(final int p_idx)
	{
		return animationPairs.get(p_idx);
	}
	
	public ISprite getSpriteOf(final int p_idx)
	{
		return get(p_idx).getSprite();
	}
	
	public int getMilliSecondsOf(final int p_idx)
	{
		return get(p_idx).getMilliSeconds();
	}
	
	public double getSecondsOf(final int p_idx)
	{
		return get(p_idx).getSeconds();
	}
	
	public int getMilliSeconds()
	{
		return msecs;
	}
	
	public double getSeconds()
	{
		return seconds;
	}
	
	public int size()
	{
		return animationPairs.size();
	}
	
	public int getStartingMsecOf(final int p_idx)
	{
		return elapsedMsecs.get(p_idx);
	}
	
	public void assign(final AnimationContainer p_container)
	{
		animationPairs.clear();
		elapsedMsecs.clear();
		
		animationPairs.addAll(p_container.animationPairs);
		elapsedMsecs.addAll(p_container.elapsedMsecs);
		
		msecs = p_container.msecs;
		seconds = p_container.seconds;
	}
	
	public void mirror()
	{
		List<AnimationPair> list = new ArrayList<AnimationPair>(animationPairs);
		for(int i = list.size() - 1; i >= 0; --i)
			animationPairs.set(i, list.get(i));
	}

}
