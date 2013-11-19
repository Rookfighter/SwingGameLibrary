package game.view.sprites;

import lib.graphics.sprites.classes.Sprite;

public class SpriteSimpleDudeUp extends Sprite {

	public SpriteSimpleDudeUp()
	{
		super(SpriteSheetSimpleDude.getInstance(), 0);
		getDimension().set(32, 32);
	}

}
