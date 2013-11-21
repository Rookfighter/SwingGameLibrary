package lib.graphics.frame;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lib.audio.ISoundLoader;
import lib.control.IKeyControl;
import lib.control.IMouseControl;
import lib.graphics.sprites.ISpriteSheetLoader;
import lib.utils.integer.Dimension2DI;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 3557793739722992405L;
	
	private ISpriteSheetLoader spriteSheetLoader;
	private ISoundLoader soundLoader;
	
	private boolean fullscreen;
	
	private IMouseControl mouseControl;
	private IKeyControl keyControl;
	
	public GameFrame()
	{
		setResizable(false);
	}	
	
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
	
	public boolean setFullscreen(final boolean p_fullscreen)
	{
		GraphicsDevice mainScreen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if(!mainScreen.isFullScreenSupported())
			return false;
		
		if(p_fullscreen)
			mainScreen.setFullScreenWindow(this);
		else
			mainScreen.setFullScreenWindow(null);
		fullscreen = p_fullscreen;
		return true;
	}
	
	public Set<Dimension2DI> getPossibleResolutions()
	{
		Set<Dimension2DI> result = new HashSet<Dimension2DI>();
		GraphicsDevice mainScreen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		for(DisplayMode mode : mainScreen.getDisplayModes())
			result.add(new Dimension2DI(mode.getWidth(), mode.getHeight()));
		
		return result;
	}
	
	public boolean setResolution(final Dimension2DI p_resolution)
	{
		if(!fullscreen)
			throw new IllegalStateException("Cannot change resolution. Application is not in fullscreen-mode.");
		
		GraphicsDevice mainScreen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if(!mainScreen.isDisplayChangeSupported())
			return false;
		
		DisplayMode newMode = findDisplayMode(p_resolution);
		
		//no fitting mode found
		if(newMode == null)
			throw new IllegalArgumentException(String.format("The resolution %s is not supported by this device.", p_resolution));
		
		mainScreen.setDisplayMode(newMode);
		
		return true;
	}
	
	private DisplayMode findDisplayMode(final Dimension2DI p_resolution)
	{
		GraphicsDevice mainScreen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		DisplayMode currentMode = mainScreen.getDisplayMode();
		DisplayMode[] modes = mainScreen.getDisplayModes();
		DisplayMode result = null;
		
		for(DisplayMode mode : modes)
		{
			if(hasSameAttributes(mode, currentMode.getRefreshRate(),
								 currentMode.getBitDepth(), p_resolution))
			{
				result = mode;
				break;
			}
		}
		
		return result;
	}
	
	private boolean hasSameAttributes(DisplayMode p_mode, int p_refreshRate, int p_bitDepth, Dimension2DI p_resolution)
	{
		return p_mode.getBitDepth() == p_bitDepth &&
			   p_mode.getRefreshRate() == p_refreshRate &&
			   p_mode.getWidth() == p_resolution.Width() &&
			   p_mode.getHeight() == p_resolution.Height();
	}
	
	public void setMouseControl(final IMouseControl p_mouseControl)
	{
		if(mouseControl != null)
			removeMouseControls();
		
		mouseControl = p_mouseControl;
		addMouseControls();
	}
	
	private void removeMouseControls()
	{
		removeMouseListener(mouseControl.getMouseListener());
		removeMouseMotionListener(mouseControl.getMouseMotionListener());
		removeMouseWheelListener(mouseControl.getMouseWheelListener());
	}
	
	private void addMouseControls()
	{
		addMouseListener(mouseControl.getMouseListener());
		addMouseMotionListener(mouseControl.getMouseMotionListener());
		addMouseWheelListener(mouseControl.getMouseWheelListener());
	}
	
	public void setKeyControl(final IKeyControl p_keyControl)
	{
		if(keyControl != null)
			removeKeyControls();
		
		keyControl = p_keyControl;
		addKeyControls();
	}
	
	private void removeKeyControls()
	{
		removeKeyListener(keyControl.getKeyListener());
	}
	
	private void addKeyControls()
	{
		addKeyListener(keyControl.getKeyListener());
	}

}
