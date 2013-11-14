package lib.utils.doubl;

public class Position2DF {

	private double x;
	private double y;
	
	public Position2DF()
	{
		set(0,0);
	}
	
	public Position2DF(final double p_x, final double p_y)
	{
		set(p_x,p_y);
	}
	
	public void setX(final double p_x)
	{
		x = p_x;
	}
	
	public void setY(final double p_y)
	{
		y = p_y;
	}
	
	public void set(final double p_x, final double p_y)
	{
		x = p_x;
		y = p_y;
	}
	
	public void assign(final Position2DF p_position)
	{
		set(p_position.x,p_position.y);
	}
	
	public void add(final Vector2D p_vector)
	{
		x += p_vector.DX;
		y += p_vector.DY;
	}
	
	public double X()
	{
		return x;
	}
	
	public double Y()
	{
		return y;
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Position2DF))
			return false;
		
		Position2DF pos = (Position2DF) p_obj;
		return x == pos.X() && y == pos.Y();
	}
	
	public Position2DF getDestinationPosition(final Vector2D p_vector)
	{
		return new Position2DF(x + p_vector.DX, y + p_vector.DY);
	}
}
