package lib.utils.integer;

import lib.utils.doubl.Rectangle2DF;

public class Rectangle2DI {

	private Position2DI rectPosition;
	private Dimension2DI rectDimension;
	
	public Rectangle2DI()
	{
		this(new Position2DI(), new Dimension2DI());
	}
	
	public Rectangle2DI(final Position2DI p_position, final Dimension2DI p_dimension)
	{
		set(p_position, p_dimension);
	}
	
	public Position2DI getPosition()
	{
		return rectPosition;
	}
	
	public Dimension2DI getDimension()
	{
		return rectDimension;
	}
	
	public void set(final Position2DI p_position, final Dimension2DI p_dimension)
	{
		rectPosition = p_position;
		rectDimension = p_dimension;
	}
	
	public void setPosition(final Position2DI p_position)
	{
		rectPosition = p_position;
	}
	
	public void setDimension(final Dimension2DI p_dimension)
	{
		rectDimension = p_dimension;
	}
	
	public void assign(final Rectangle2DI p_rect)
	{
		rectPosition.assign(p_rect.rectPosition);
		rectDimension.assign(p_rect.rectDimension);
	}
	
	public void assign(final Rectangle2DF p_rect)
	{
		rectPosition.assign(p_rect.getPosition());
		rectDimension.assign(p_rect.getDimension());
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Rectangle2DI))
			return false;
		Rectangle2DI rect = (Rectangle2DI) p_obj;
		return rectDimension.equals(rect.rectDimension) && rectPosition.equals(rect.rectPosition);
	}
}
