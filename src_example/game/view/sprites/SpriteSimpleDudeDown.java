package game.view.sprites;

import lib.graphics.sprites.classes.Sprite;

public class SpriteSimpleDudeDown extends Sprite {

	public SpriteSimpleDudeDown()
	{
		super(SpriteSheetSimpleDude.getInstance(), 3);
		getDimension().set(32, 32);
	}

}
