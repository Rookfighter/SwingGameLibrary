package lib.utils.integer;

import lib.utils.doubl.Position2DF;
import lib.utils.doubl.Vector2D;

public class Position2DI {

	private int x;
	private int y;
	
	public Position2DI()
	{
		set(0,0);
	}
	
	public Position2DI(final int p_x, final int p_y)
	{
		set(p_x,p_y);
	}
	
	public void setX(final int p_x)
	{
		x = p_x;
	}
	
	public void setY(final int p_y)
	{
		y = p_y;
	}
	
	public void assign(final Position2DI p_position)
	{
		set(p_position.x,p_position.y);
	}
	
	public void assign(final Position2DF p_position)
	{
		set((int) p_position.X(), (int) p_position.Y());
	}
	
	public void set(final int p_x, final int p_y)
	{
		x = p_x;
		y = p_y;
	}
	
	public void add(final Vector2D p_vector)
	{
		x += p_vector.DX;
		y += p_vector.DY;
	}
	
	public int X()
	{
		return x;
	}
	
	public int Y()
	{
		return y;
	}
	
	public Position2DI getDestinationPosition(final Vector2D p_vector)
	{
		return new Position2DI(x + (int)p_vector.DX, y + (int)p_vector.DY);
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Position2DI))
			return false;
		
		Position2DI pos = (Position2DI) p_obj;
		return x == pos.X() && y == pos.Y();
	}
	
}
