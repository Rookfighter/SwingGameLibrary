package lib.graphics.frame;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lib.audio.ISoundLoader;
import lib.graphics.sprites.ISpriteSheetLoader;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 3557793739722992405L;
	
	private ISpriteSheetLoader spriteSheetLoader;
	private ISoundLoader soundLoader;
	
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
	
	public void setSoundLoader(final ISoundLoader p_soundLoader)
	{
		soundLoader = p_soundLoader;
	}
	
	public void loadSounds()
	{
		try
		{
			soundLoader.loadSounds();
		}
		catch (Exception e)
		{
			String msg = String.format("Could not load Sounds:\n%s.",e.getMessage() );
			JOptionPane.showMessageDialog(this, msg, "Error Sounds", JOptionPane.ERROR_MESSAGE);
		}
	}

}
