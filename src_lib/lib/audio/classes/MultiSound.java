package lib.audio.classes;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lib.audio.IMultiSound;
import lib.audio.ISound;
import lib.audio.ISoundFactory;

public class MultiSound implements IMultiSound{

	private static final float DEF_VOL = 100f;
	
	private List<ISound> soundList;
	private ISoundFactory soundFactory;
	private float volume;
	
	public MultiSound(final ISoundFactory p_factory)
	{
		soundList = new LinkedList<ISound>();
		setSoundFactory(p_factory);
		volume = DEF_VOL;
	}
	
	
	public void setSoundFactory(final ISoundFactory p_factory)
	{
		soundList.clear();
		soundFactory = p_factory;
	}
	
	@Override
	public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		ISound toStart = getSound();
		
		if(toStart == null)
			toStart = addSound();
		
		toStart.start();
	}
	
	private ISound getSound()
	{
		ISound result = null;
		for(ISound sound : soundList)
		{
			if(!sound.running())
			{
				result = sound;
				break;
			}
		}
		
		return result;
	}
	
	private ISound addSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		ISound result = soundFactory.createSound();
		result.load();
		result.setRepeat(false);
		result.closeOnEnd(false);
		result.setVolume(volume);
		soundList.add(result);
		return result;
	}


	@Override
	public void setVolume(int p_volume)
	{
		volume = p_volume;
		setAllVolumes();
	}
	
	private void setAllVolumes()
	{
		for(ISound sound : soundList)
			sound.setVolume(volume);
	}


	@Override
	public float getVolume()
	{
		return volume;
	}

}
