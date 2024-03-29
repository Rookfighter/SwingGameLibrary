package lib.graphics.animation.classes;

import java.awt.Graphics;

import lib.graphics.animation.IAnimation;
import lib.graphics.sprites.ISprite;
import lib.utils.DeltaTime;
import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;

public class Animation implements IAnimation {

	private AnimationContainer animationContainer;
	
	private boolean repeat;
	
	private int currentIndex;
	private int elapsedMsecs;
	
	private Position2DI position;
	private Dimension2DI dimension;
	
	private DeltaTime delta;
	
	private double rotation;
	private int drawOrder;

	public Animation()
	{
		animationContainer = new AnimationContainer();
		position = new Position2DI();
		dimension = new Dimension2DI();
		repeat = true;
		reset();
	}
	
	@Override
	public void draw(Graphics p_graphic)
	{
		increaseElapsedTime();
		calculateIndex();
		drawCurrentSprite(p_graphic);
	}
	
	private void drawCurrentSprite(final Graphics p_graphic)
	{
		ISprite sprite = animationContainer.getSpriteOf(currentIndex);
		sprite.setRotation(rotation);
		sprite.setDrawOrder(drawOrder);
		sprite.draw(p_graphic);
	}
	
	private void increaseElapsedTime()
	{
		elapsedMsecs += delta.getMilli();
	}
	
	private void calculateIndex()
	{
		repeat();
		incrementIndex();
	}
	
	private void repeat()
	{
		if(repeat && timeIsOver())
			reset();
	}
	
	private boolean timeIsOver()
	{
		return elapsedMsecs >= animationContainer.getMilliSeconds();
	}
	
	private void incrementIndex()
	{
		if(nextIndexIsInRange() &&
				timeForNextIndexHasCome())
		{
			++currentIndex;
			incrementIndex();
		}
	}
	
	private boolean nextIndexIsInRange()
	{
		return currentIndex + 1 < animationContainer.size();
	}
	
	private boolean timeForNextIndexHasCome()
	{
		return  elapsedMsecs >= animationContainer.getStartingMsecOf(currentIndex + 1);
	}
	
	@Override
	public void reset()
	{
		elapsedMsecs = 0;
		currentIndex = 0;
	}
	
	

	@Override
	public int getDrawOrder()
	{
		return drawOrder;
	}

	@Override
	public void setDrawOrder(int p_drawOrder)
	{
		drawOrder = p_drawOrder;
	}

	@Override
	public void setDefaultDrawOrder()
	{
		drawOrder = position.Y();
	}

	@Override
	public void setDeltaTime(DeltaTime p_delta)
	{
		delta = p_delta;
	}

	@Override
	public boolean running()
	{
		return repeat || elapsedMsecs < animationContainer.getMilliSeconds();
	}

	@Override
	public void setRepeat(boolean p_repeat)
	{
		repeat = p_repeat;
	}

	@Override
	public void setAnimationContainer(AnimationContainer p_container)
	{
		animationContainer = p_container;
	}

	@Override
	public AnimationContainer getAnimationContainer()
	{
		return animationContainer;
	}

	@Override
	public void invert()
	{
		animationContainer.mirror();
	}

	@Override
	public Position2DI getPosition()
	{
		return position;
	}

	@Override
	public void setPosition(Position2DI p_position)
	{
		position = p_position;
		setSpritePositions();
	}
	
	private void setSpritePositions()
	{
		for(int i = 0; i < animationContainer.size(); ++i)
			animationContainer.getSpriteOf(i).setPosition(position);
	}

	@Override
	public Dimension2DI getDimension()
	{
		return dimension;
	}

	@Override
	public void setDimension(Dimension2DI p_dimension)
	{
		dimension = p_dimension;
		setSpriteDimensions();
	}
	
	private void setSpriteDimensions()
	{
		for(int i = 0; i < animationContainer.size(); ++i)
			animationContainer.getSpriteOf(i).setDimension(dimension);
	}

	@Override
	public void applyChanges()
	{
		setSpritePositions();
		setSpriteDimensions();
		animationContainer.calculateTime();
	}

	@Override
	public void setRotation(double p_radian)
	{
		rotation = p_radian;
		for(int i = 0; i < animationContainer.size(); ++i)
			animationContainer.getSpriteOf(i).setRotation(p_radian);
		
	}

	@Override
	public double getRotation()
	{
		return rotation;
	}
	

}
