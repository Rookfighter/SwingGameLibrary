package game.view.sprites;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lib.graphics.sprites.ISpriteSheet;
import lib.graphics.sprites.ISpriteSheetLoader;

public class GameSpriteSheetLoader implements ISpriteSheetLoader {

	List<ISpriteSheet> spriteSheetList;
	
	public GameSpriteSheetLoader()
	{
		generateSpriteSheetList();
	}
	
	private void generateSpriteSheetList()
	{
		spriteSheetList = new ArrayList<ISpriteSheet>(2);
		spriteSheetList.add(SpriteSheetSimpleDude.getInstance());
		spriteSheetList.add(SpriteSheetOthers.getInstance());
	}
	
	@Override
	public void loadSpriteSheets() throws IOException
	{
		for(ISpriteSheet spriteSheet : spriteSheetList)
			spriteSheet.loadImage();
	}

	@Override
	public List<ISpriteSheet> getSpriteSheetList() 
	{
		return spriteSheetList;
	}

}
