package lib.utils.doubl;

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
	
	public void assign(final Vector2D p_vector)
	{
		DX = p_vector.DX;
		DY = p_vector.DY;
	}
}
