package lib.utils.doubl;

public class Circle2DF {

	private double radius;
	private Position2DF mid;
	
	public Circle2DF()
	{
		this(new Position2DF(), 1.0);
	}
	
	public Circle2DF(final Position2DF p_mid, final double p_radius)
	{
		set(p_mid, p_radius);
	}
	
	public double Radius()
	{
		return radius;
	}
	
	public Position2DF Mid()
	{
		return mid;
	}
	
	public void set(final Position2DF p_mid, final double p_radius)
	{
		if(p_radius <= 0)
			throw new IllegalArgumentException(String.format("Radius of Circle2D cannot be zero or negative (%.2f).",p_radius));
		radius = p_radius;
		mid = p_mid;
	}
	
	public void setMid(final Position2DF p_mid)
	{
		mid = p_mid;
	}
	
	public void setRadius(final double p_radius)
	{
		set(mid, p_radius);
	}
	
	public void assign(final Circle2DF p_circle)
	{
		radius = p_circle.Radius();
		mid.assign(p_circle.Mid());
	}
	
	@Override
	public boolean equals(final Object p_obj)
	{
		if(!(p_obj instanceof Circle2DF))
			return false;
		Circle2DF circle = (Circle2DF) p_obj;
		return radius == circle.radius && mid.equals(circle.mid);
	}
}
