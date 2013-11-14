package game.entities;

import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Position2DF;
import lib.utils.doubl.Rectangle2DF;
import lib.utils.doubl.Vector2D;

public interface IFieldOfVision {

	public Position2DF getPosition();
	public void setPosition(final Position2DF p_position);
	
	public Dimension2DF getDimension();
	public void setDimension(final Dimension2DF p_dimension);
	
	public Rectangle2DF getRectangle();
	public void setRectangle(final Rectangle2DF p_rect);
	
	public Vector2D getVector();
	public void setVector(final Vector2D p_vector);
	
}
