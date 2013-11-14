package lib.utils.integer;

import lib.utils.doubl.Circle2DF;

public class Circle2DI {

	private double radius;
	private Position2DI mid;
	
	public Circle2DI()
	{
		this(new Position2DI(), 1.0);
	}
	
	public Circle2DI(final Position2DI p_mid, final double p_radius)
	{
		set(p_mid, p_radius);
	}
	
	public double Radius()
	{
		return radius;
	}
	
	public Position2DI Mid()
	{
		return mid;
	}
	
	public void set(final Position2DI p_mid, final double p_radius)
	{
		if(p_radius <= 0)
			throw new IllegalArgumentException(String.format("Radius of Circle2D cannot be zero or negative (%.2f).",p_radius));
		radius = p_radius;
		mid = p_mid;
	}
	
	public void setMid(final Position2DI p_mid)
	{
		mid = p_mid;
	}
	
	public void setRadius(final double p_radius)
	{
		set(mid, p_radius);
	}
	
	public void assign(final Circle2DI p_circle)
	{
		radius = p_circle.Radius();
		mid.assign(p_circle.Mid());
	}
	
	public void assign(final Circle2DF p_circle)
	{
		radius = p_circle.Radius();
		mid.assign(p_circle.Mid());
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Circle2DI))
			return false;
		Circle2DI circle = (Circle2DI) p_obj;
		return radius == circle.radius && mid.equals(circle.mid);
	}
}
