package game.audio.music;

import lib.audio.classes.Sound;

public class BackgroundMusic extends Sound{

	private static BackgroundMusic instance = null;
	
	private BackgroundMusic()
	{
		super("./sounds/DST_Aircord.wav");
		setRepeat(false);
	}
	
	public static BackgroundMusic getInstance()
	{
		if(instance == null);
			instance = new BackgroundMusic();
		return instance;
	}
	
}
