package lib.multimedia.classes;

import java.awt.Graphics;
import java.util.List;

import lib.audio.IMultiSound;
import lib.graphics.animation.IAnimation;
import lib.graphics.sprites.ISprite;
import lib.multimedia.IMultimediaObject;
import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;

public class MultimediaObject implements IMultimediaObject{
	
	public MultimediaObject()
	{
		
	}

	@Override
	public Position2DI getPosition()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Position2DI p_position)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension2DI getDimension()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDimension(Dimension2DI p_dimension)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation(double p_radian)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getRotation()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics p_graphic)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDrawOrder()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDrawOrder(int p_drawOrder)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultDrawOrder()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ISprite getSprite(int p_idx)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAnimation getAnimation(int p_idx)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMultiSound getSound(int p_idx)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISprite> getSprites()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IAnimation> getAnimations()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IMultiSound> getSounds()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
