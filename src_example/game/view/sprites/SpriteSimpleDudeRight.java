package game.view.sprites;

import lib.graphics.sprites.classes.Sprite;

public class SpriteSimpleDudeRight extends Sprite {

	public SpriteSimpleDudeRight()
	{
		super(SpriteSheetSimpleDude.getInstance(), 1);
		getDimension().set(32, 32);
	}
}
