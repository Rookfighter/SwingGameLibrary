package lib.audio;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface ISoundLoader {

	void loadSounds() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
}
