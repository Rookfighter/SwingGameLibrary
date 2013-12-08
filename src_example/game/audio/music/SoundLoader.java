package game.audio.music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lib.audio.ISound;
import lib.audio.ISoundLoader;

public class SoundLoader implements ISoundLoader {

	private List<ISound> soundList;
	
	public SoundLoader()
	{
		generateSoundList();
	}
	
	private void generateSoundList()
	{
		soundList = new ArrayList<ISound>(1);
		soundList.add(BackgroundMusic.getInstance());
	}
	
	@Override
	public void loadSounds() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException
	{
		for(ISound sound : soundList)
			sound.load();
	}

}
