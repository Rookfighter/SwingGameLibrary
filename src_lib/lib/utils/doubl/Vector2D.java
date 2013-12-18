package lib.utils.doubl;

import lib.utils.integer.Position2DI;

public class Vector2D {

	public double DX;
	public double DY;
	
	public Vector2D()
	{
		this(1.0, 1.0);
	}
	
	public Vector2D(final double p_dx, final double p_dy)
	{
		set(p_dx,p_dy);
	}
	
	public void add(final Vector2D p_vector)
	{
		DX += p_vector.DX;
		DY += p_vector.DY;
	}
	
	public void multiply(final double p_factor)
	{
		DX *= p_factor;
		DY *= p_factor;
	}
	
	public void set(final double p_dx, final double p_dy)
	{
		DX = p_dx;
		DY = p_dy;
	}
	
	public void invert()
	{
		DX = -DX;
		DY = -DY;
	}
	
	public Vector2D getInversion()
	{
		return new Vector2D(-DX, -DY);
	}
	
	public void assign(final Vector2D p_vector)
	{
		DX = p_vector.DX;
		DY = p_vector.DY;
	}
	
	public static Vector2D vectorBetween(final Position2DF p_start, final Position2DF p_end)
	{
		return vectorBetween(p_start.X(), p_start.Y(), p_end.X(), p_end.Y());
	}
	
	public static Vector2D vectorBetween(final Position2DI p_start, final Position2DI p_end)
	{
		return vectorBetween(p_start.X(), p_start.Y(), p_end.X(), p_end.Y());
	}
	
	private static Vector2D vectorBetween(final double p_x1, final double p_y1,
										  final double p_x2, final double p_y2)
	
	{
		double dx = p_x1 - p_x2;
		double dy = p_y1 - p_y2;
		return new Vector2D(dx,dy);
	}
}
