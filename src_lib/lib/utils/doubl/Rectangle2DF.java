package lib.utils.doubl;

public class Rectangle2DF {

	private Position2DF rectPosition;
	private Dimension2DF rectDimension;
	
	public Rectangle2DF()
	{
		this(new Position2DF(), new Dimension2DF());
	}
	
	public Rectangle2DF(final Position2DF p_position, final Dimension2DF p_dimension)
	{
		set(p_position, p_dimension);
	}
	
	public Position2DF getPosition()
	{
		return rectPosition;
	}
	
	public Dimension2DF getDimension()
	{
		return rectDimension;
	}
	
	public void set(final Position2DF p_position, final Dimension2DF p_dimension)
	{
		rectPosition = p_position;
		rectDimension = p_dimension;
	}
	
	public void setPosition(final Position2DF p_position)
	{
		rectPosition = p_position;
	}
	
	public void setDimension(final Dimension2DF p_dimension)
	{
		rectDimension = p_dimension;
	}
	
	public void assign(final Rectangle2DF p_rect)
	{
		rectPosition.assign(p_rect.rectPosition);
		rectDimension.assign(p_rect.rectDimension);
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Rectangle2DF))
			return false;
		Rectangle2DF rect = (Rectangle2DF) p_obj;
		return rectDimension.equals(rect.rectDimension) && rectPosition.equals(rect.rectPosition);
	}
}
