package game.view.sprites;

import lib.graphics.sprites.Sprite;
import lib.utils.integer.Dimension2DI;

public class SpriteSimpleDudeRight extends Sprite {

	public SpriteSimpleDudeRight()
	{
		super(SpriteSheetSimpleDude.getInstance(), 1);
		SpriteDimension = new Dimension2DI(32, 32);
	}
}
