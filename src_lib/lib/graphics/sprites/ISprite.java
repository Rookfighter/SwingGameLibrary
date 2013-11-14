package lib.graphics.sprites;

import lib.graphics.IDrawable;
import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;

public interface ISprite extends IDrawable {

	Position2DI getPosition();
	void setPosition(final Position2DI p_position);
	
	Dimension2DI getDimension();
	void setDimension(final Dimension2DI p_dimension);
}
