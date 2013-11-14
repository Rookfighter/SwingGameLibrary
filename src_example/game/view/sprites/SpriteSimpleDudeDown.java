package game.view.sprites;

import lib.graphics.sprites.Sprite;
import lib.utils.integer.Dimension2DI;

public class SpriteSimpleDudeDown extends Sprite {

	public SpriteSimpleDudeDown()
	{
		super(SpriteSheetSimpleDude.getInstance(), 3);
		SpriteDimension = new Dimension2DI(32, 32);
	}

}
