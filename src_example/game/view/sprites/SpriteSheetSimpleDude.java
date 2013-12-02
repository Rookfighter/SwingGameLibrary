package game.view.sprites;

import lib.graphics.sprites.classes.SpriteSheet;
import lib.utils.integer.Dimension2DI;

public class SpriteSheetSimpleDude extends SpriteSheet {

private static final SpriteSheetSimpleDude simpleDudeSheet = new SpriteSheetSimpleDude();
	
	private SpriteSheetSimpleDude()
	{
		super(new Dimension2DI(32, 32), "images\\circles.png");
	}
	
	public static SpriteSheetSimpleDude getInstance()
	{
		return simpleDudeSheet;
	}

}
