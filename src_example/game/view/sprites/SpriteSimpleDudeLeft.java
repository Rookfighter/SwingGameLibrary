package game.view.sprites;

import lib.graphics.sprites.classes.Sprite;

public class SpriteSimpleDudeLeft extends Sprite {

	public SpriteSimpleDudeLeft()
	{
		super(SpriteSheetSimpleDude.getInstance(), 2);
		getDimension().set(32, 32);
	}

}
