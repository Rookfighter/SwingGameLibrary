package game.view.sprites;

import lib.graphics.sprites.classes.SpriteSheet;
import lib.utils.integer.Dimension2DI;

public class SpriteSheetOthers extends SpriteSheet{

	private static SpriteSheetOthers othersSheet = null;
	
	private SpriteSheetOthers()
	{
		super(new Dimension2DI(32, 32), "images/default.png");
	}
	
	public static SpriteSheetOthers getInstance()
	{
		if(othersSheet == null)
			othersSheet = new SpriteSheetOthers();
		return othersSheet;
	}
}
