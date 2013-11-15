package game.audio.music;

import lib.audio.classes.Sound;

public class BackgroundMusic extends Sound{

	private static BackgroundMusic backgroundMusic = null;
	
	private BackgroundMusic()
	{
		super("./sounds/DST_Aircord.wav");
		setRepeat(false);
	}
	
	public static BackgroundMusic getInstance()
	{
		if(backgroundMusic == null)
			backgroundMusic = new BackgroundMusic();
		return backgroundMusic;
	}
	
}
