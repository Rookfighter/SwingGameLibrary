package lib.graphics.sprites.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lib.graphics.sprites.ISpriteSheet;
import lib.graphics.sprites.ISpriteSheetLoader;

public class SpriteSheetLoader implements ISpriteSheetLoader {

	private List<ISpriteSheet> spriteSheetList;
	
	public SpriteSheetLoader(final int count)
	{
		spriteSheetList = new ArrayList<ISpriteSheet>(count);
	}
	
	@Override
	public void loadSpriteSheets() throws IOException
	{
		for(ISpriteSheet spriteSheet : spriteSheetList)
			spriteSheet.loadImage();
	}

	public void addSpriteSheet(final ISpriteSheet p_spriteSheet) 
	{
		spriteSheetList.add(p_spriteSheet);
	}
	
	public void clear()
	{
		spriteSheetList.clear();
	}
}
