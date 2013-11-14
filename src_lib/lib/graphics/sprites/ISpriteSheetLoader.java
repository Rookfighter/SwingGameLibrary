package lib.graphics.sprites;

import java.io.IOException;
import java.util.List;

public interface ISpriteSheetLoader {

	void loadSpriteSheets() throws IOException;
	List<ISpriteSheet> getSpriteSheetList();
}
