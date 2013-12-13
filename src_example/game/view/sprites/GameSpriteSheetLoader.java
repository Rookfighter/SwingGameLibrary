package game.view.sprites;

import lib.graphics.sprites.classes.SpriteSheetLoader;

public class GameSpriteSheetLoader extends SpriteSheetLoader {
	
	public GameSpriteSheetLoader()
	{
		super(2);
		addSpriteSheet(SpriteSheetSimpleDude.getInstance());
		addSpriteSheet(SpriteSheetOthers.getInstance());
	}
	
}
