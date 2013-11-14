package lib.utils.doubl;

import java.awt.Dimension;

public class Dimension2DF {
	
	private double height;
	private double width;
	
	public Dimension2DF()
	{
		this(1,1);
	}
	
	public Dimension2DF(final double p_width, final double p_height)
	{
		set(p_width,p_height);
	}
	
	public void set(final double p_width, final double p_height)
	{
		setWidth(p_width);
		setHeight(p_height);
	}
	
	public void setWidth(final double p_width)
	{
		if(p_width <= 0)
			throw new IllegalArgumentException(String.format("Width of dimension cannot be zero or negative (%d)",p_width));
		width = p_width;
	}
	
	public void setHeight(final double p_height)
	{
		if(p_height <= 0)
			throw new IllegalArgumentException(String.format("Height of dimension cannot be zero or negative (%d)",p_height));
		height = p_height;
	}
	
	public void assign(final Dimension2DF p_dimension)
	{
		height = p_dimension.height;
		width = p_dimension.width;
	}
	
	public void assign(final java.awt.Dimension p_dimension)
	{
		height = p_dimension.getHeight();
		width = p_dimension.getWidth();
	}
	
	public double Width()
	{
		return width;
	}
	
	public double Height()
	{
		return height;
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Dimension2DF))
			return false;
		Dimension2DF dim = (Dimension2DF) p_obj;
		return width == dim.Width() && height == dim.Height();
	}
	
	public Dimension toAWTDimension()
	{
		return new Dimension((int) width, (int) height);
	}
}
