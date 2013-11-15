package lib.audio.classes;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lib.audio.ISound;

public class Sound implements ISound{

	private File audioFile;
	private Clip audioClip;
	private boolean repeat;
	
	public Sound(final String p_path)
	{
		repeat = false;
		setPath(p_path);
	}

	private void setPath(String p_path)
	{
		setFile(new File(p_path));
	}
	
	private void setFile(final File p_file)
	{
		if(!p_file.isFile())
			throw new IllegalArgumentException(String.format("The Sound file does not exist: %s.",p_file.getAbsolutePath()));
		audioFile = p_file;
	}

	@Override
	public void load() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		DataLine.Info lineInfo = new DataLine.Info(Clip.class, audioStream.getFormat());
		audioClip = (Clip) AudioSystem.getLine(lineInfo);
		audioClip.addLineListener(getRepeatListener());
		audioClip.open(audioStream);
	}

	@Override
	public void start()
	{
		audioClip.start();
	}

	@Override
	public void stop()
	{
		audioClip.stop();
	}

	@Override
	public void restart()
	{
		if(running())
			stop();
		start();
	}

	@Override
	public boolean running()
	{
		return audioClip.isRunning();
	}

	@Override
	public void setRepeat(boolean p_repeat)
	{
		repeat = p_repeat;
	}

	@Override
	public boolean repeat()
	{
		return repeat;
	}
	
	private LineListener getRepeatListener()
	{
		return new LineListener() {
		      public void update(LineEvent event) {
		        if (event.getType() == LineEvent.Type.STOP) {
		          audioClip.close();
		        }
		      }
		    };
	}
	
	
}
