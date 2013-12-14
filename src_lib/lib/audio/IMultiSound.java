package lib.audio;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface IMultiSound {

	void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	void setVolume(final int p_volume);
	float getVolume();
}
