package lib.multimedia.classes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import lib.audio.IMultiSound;
import lib.graphics.animation.IAnimation;
import lib.graphics.sprites.ISprite;
import lib.multimedia.IMultimediaObject;
import lib.utils.DeltaTime;
import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;

public class MultimediaObject implements IMultimediaObject{
	
	private ISprite toDraw;
	
	private List<ISprite> sprites;
	private List<IAnimation> animations;
	private List<IMultiSound> sounds;
	
	private Position2DI position;
	private Dimension2DI dimension;
	
	private double rotation;
	private int drawOrder;
	
	private DeltaTime delta;
	
	public MultimediaObject()
	{
		sprites = new ArrayList<ISprite>();
		animations = new ArrayList<IAnimation>();
		sounds = new ArrayList<IMultiSound>();
		
		position = new Position2DI();
		dimension = new Dimension2DI();
	}
	
	@Override
	public void draw(Graphics p_graphic)
	{
		if(toDraw != null)
			drawCurrentSprite(p_graphic);
	}
	
	private void drawCurrentSprite(final Graphics p_graphic)
	{
		toDraw.setRotation(rotation);
		toDraw.setDrawOrder(drawOrder);
		toDraw.draw(p_graphic);
	}
	
	@Override
	public void addSprite(ISprite p_sprite)
	{
		p_sprite.setPosition(position);
		p_sprite.setDimension(dimension);
		sprites.add(p_sprite);
	}

	@Override
	public void addAnimation(IAnimation p_animation)
	{
		p_animation.setPosition(position);
		p_animation.setDimension(dimension);
		p_animation.setDeltaTime(delta);
		animations.add(p_animation);
	}

	@Override
	public void addSound(IMultiSound p_sound)
	{
		sounds.add(p_sound);
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
		setPositions();
	}
	
	private void setPositions()
	{
		for(ISprite sprite : sprites)
			sprite.setPosition(position);
		for(IAnimation animation : animations)
			animation.setPosition(position);
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
		setDimensions();
	}
	
	private void setDimensions()
	{
		for(ISprite sprite : sprites)
			sprite.setDimension(dimension);
		for(IAnimation animation : animations)
			animation.setDimension(dimension);
	}

	@Override
	public void setRotation(double p_radian)
	{
		rotation = p_radian;
	}
	
	@Override
	public double getRotation()
	{
		return rotation;
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
	public ISprite getSprite(int p_idx)
	{
		return sprites.get(p_idx);
	}

	@Override
	public IAnimation getAnimation(int p_idx)
	{
		return animations.get(p_idx);
	}

	@Override
	public IMultiSound getSound(int p_idx)
	{
		return sounds.get(p_idx);
	}

	@Override
	public List<ISprite> getSprites()
	{
		return sprites;
	}

	@Override
	public List<IAnimation> getAnimations()
	{
		return animations;
	}

	@Override
	public List<IMultiSound> getSounds()
	{
		return sounds;
	}

	@Override
	public void setAnimationToDraw(int p_idx)
	{
		if(toDraw instanceof IAnimation)
			((IAnimation) toDraw).reset();
		
		toDraw = getAnimation(p_idx);
	}

	@Override
	public void setSpriteToDraw(int p_idx)
	{
		toDraw = getSprite(p_idx);
	}

	@Override
	public void setDeltaTime(DeltaTime p_delta)
	{
		delta = p_delta;
		setDeltaTimes();
	}
	
	private void setDeltaTimes()
	{
		for(IAnimation animation : animations)
			animation.setDeltaTime(delta);
	}

	@Override
	public DeltaTime getDeltaDeltaTime()
	{
		return delta;
	}

	@Override
	public ISprite getToDraw()
	{
		return toDraw;
	}

}
