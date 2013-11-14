package game.entities.classes;

import game.entities.IFieldOfVision;
import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Position2DF;
import lib.utils.doubl.Rectangle2DF;
import lib.utils.doubl.Vector2D;

public class FieldOfVision implements IFieldOfVision {

	private Rectangle2DF fovRect;
	private Vector2D fovVector;
	
	public FieldOfVision()
	{
		this(new Position2DF(), new Dimension2DF());
	}
	
	public FieldOfVision(final Position2DF p_position, final Dimension2DF p_dimension)
	{
		fovRect = new Rectangle2DF(p_position, p_dimension);
		fovVector = new Vector2D(0,0);
	}
	
	@Override
	public Position2DF getPosition()
	{
		return fovRect.getPosition();
	}

	@Override
	public void setPosition(Position2DF p_position)
	{
		fovRect.setPosition(p_position);
	}

	@Override
	public Dimension2DF getDimension()
	{
		return fovRect.getDimension();
	}

	@Override
	public void setDimension(Dimension2DF p_dimension)
	{
		fovRect.setDimension(p_dimension);
	}

	@Override
	public Vector2D getVector()
	{
		return fovVector;
	}

	@Override
	public void setVector(Vector2D p_vector)
	{
		fovVector = p_vector;
	}

	@Override
	public Rectangle2DF getRectangle()
	{
		return fovRect;
	}

	@Override
	public void setRectangle(Rectangle2DF p_rect)
	{
		fovRect = p_rect;		
	}

}
