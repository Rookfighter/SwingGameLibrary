package game.view.sprites;

import lib.graphics.sprites.Sprite;
import lib.utils.integer.Dimension2DI;

public class SpriteSimpleDudeLeft extends Sprite {

	public SpriteSimpleDudeLeft()
	{
		super(SpriteSheetSimpleDude.getInstance(), 2);
		SpriteDimension = new Dimension2DI(32, 32);
	}

}
