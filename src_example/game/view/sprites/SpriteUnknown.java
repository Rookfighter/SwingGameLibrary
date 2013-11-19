package game.view.sprites;

import lib.graphics.sprites.classes.Sprite;

public class SpriteUnknown extends Sprite {

	public SpriteUnknown()
	{
		super(SpriteSheetOthers.getInstance(), 0);
		getDimension().set(32, 32);
	}
}
