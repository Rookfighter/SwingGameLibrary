package lib.graphics.sprites;

import java.awt.Graphics;
import java.io.IOException;

import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;

public interface ISpriteSheet {
	
	int getMaxSpriteCount();
	void loadImage() throws IOException;
	void drawSprite(final int p_index,
					final Position2DI p_position,
					final Graphics p_graphic);
	void drawSprite(final int p_index,
					final Position2DI p_position,
					final Dimension2DI p_dimension,
					final Graphics p_graphic);
	void drawSprite(final int p_index,
					final Position2DI p_position,
					final Dimension2DI p_dimension,
					final double p_radian,
					final Graphics p_graphic);
}
