package lib.audio;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface ISound {
	
	void load() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	void start();
	void stop();
	void restart();
	void reset();
	void close() throws IOException;
	
	boolean running();
	
	void setRepeat(final boolean p_repeat);
	boolean repeat();
	
	void closeOnEnd(final boolean p_close);
	
	void setVolume(final float p_volume);
	float getVolume();
	float getMinVolume();
	float getMaxVolume();
}
