package lib.audio;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface ISound {
	
	void load() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	void start();
	void stop();
	void restart();
	
	boolean running();
	
	void setRepeat(final boolean p_repeat);
	boolean repeat();
}
