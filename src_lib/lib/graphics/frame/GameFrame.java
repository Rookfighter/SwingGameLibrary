package lib.graphics.frame;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lib.graphics.sprites.ISpriteSheetLoader;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 3557793739722992405L;
	
	private ISpriteSheetLoader spriteSheetLoader;
	
	public ISpriteSheetLoader getSpriteSheetLoader()
	{
		return spriteSheetLoader;
	}
	
	public void setSpriteSheetLoader(final ISpriteSheetLoader p_loader)
	{
		spriteSheetLoader = p_loader;
	}
	
	public void loadSpriteSheets()
	{
		try
		{
			spriteSheetLoader.loadSpriteSheets();
		}
		catch (IOException e)
		{
			String msg = String.format("Could not load Sprite-Sheets:\n%s.",e.getMessage() );
			JOptionPane.showMessageDialog(this, msg, "Error SpriteSheet", JOptionPane.ERROR_MESSAGE);
		}
	}

}
