package game.view.sprites;

import lib.graphics.sprites.SpriteSheet;
import lib.utils.integer.Dimension2DI;

public class SpriteSheetSimpleDude extends SpriteSheet {

private static SpriteSheetSimpleDude simpleDudeSheet = null;
	
	private SpriteSheetSimpleDude()
	{
		super(new Dimension2DI(32, 32), "images\\circles.png");
	}
	
	public static SpriteSheetSimpleDude getInstance()
	{
		if(simpleDudeSheet == null)
			simpleDudeSheet = new SpriteSheetSimpleDude();
		return simpleDudeSheet;
	}

}
