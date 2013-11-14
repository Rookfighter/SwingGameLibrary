package game.view.sprites;

import lib.graphics.sprites.Sprite;
import lib.utils.integer.Dimension2DI;

public class SpriteUnknown extends Sprite {

	public SpriteUnknown()
	{
		super(SpriteSheetOthers.getInstance(), 0);
		SpriteDimension = new Dimension2DI(32, 32);
	}
}
