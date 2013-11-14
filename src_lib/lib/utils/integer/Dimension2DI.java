package lib.utils.integer;

import java.awt.Dimension;

import lib.utils.doubl.Dimension2DF;

public class Dimension2DI {
	
	private int height;
	private int width;
	
	public Dimension2DI()
	{
		this(1,1);
	}
	
	public Dimension2DI(final int p_width, final int p_height)
	{
		set(p_width,p_height);
	}
	
	public void set(final int p_width, final int p_height)
	{
		setWidth(p_width);
		setHeight(p_height);
	}
	
	public void setWidth(final int p_width)
	{
		if(p_width <= 0)
			throw new IllegalArgumentException(String.format("Width of dimension cannot be zero or negative (%d)",p_width));
		width = p_width;
	}
	
	public void setHeight(final int p_height)
	{
		if(p_height <= 0)
			throw new IllegalArgumentException(String.format("Height of dimension cannot be zero or negative (%d)",p_height));
		height = p_height;
	}
	
	public int Width()
	{
		return width;
	}
	
	public int Height()
	{
		return height;
	}
	
	public void assign(final Dimension2DI p_dimension)
	{
		height = p_dimension.height;
		width = p_dimension.width;
	}
	
	public void assign(final java.awt.Dimension p_dimension)
	{
		height = (int) p_dimension.getHeight();
		width = (int)p_dimension.getWidth();
	}
	
	public void assign(final Dimension2DF p_dimension)
	{
		height = (int) p_dimension.Height();
		width = (int) p_dimension.Width();
	}
	
	public Dimension toAWTDimension()
	{
		return new Dimension(width, height);
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Dimension2DI))
			return false;
		
		Dimension2DI dim = (Dimension2DI) p_obj;
		return width == dim.Width() && height == dim.Height();
	}
	
	
}
