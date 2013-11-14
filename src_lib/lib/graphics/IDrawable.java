package lib.graphics;

import java.awt.Graphics;

public interface IDrawable {

	void draw(final Graphics p_graphic);
	
	int getDrawOrder();
	void setDrawOrder(final int p_drawOrder);
	void setDefaultDrawOrder();
}
