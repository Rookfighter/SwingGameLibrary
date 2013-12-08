package game.audio.music;

import lib.audio.classes.Sound;

public class BackgroundMusic extends Sound{

	private static BackgroundMusic backgroundMusic = new BackgroundMusic();
	
	private BackgroundMusic()
	{
		super("./sounds/DST_Aircord.wav");
		setRepeat(false);
	}
	
	public static BackgroundMusic getInstance()
	{
		return backgroundMusic;
	}
	
}
