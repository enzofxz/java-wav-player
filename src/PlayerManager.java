import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayerManager {
	static AudioInputStream audioStream; // creates a clip and a audioinputstream to play the wav file
    static Clip clip;
    
	public static void play(File song) throws Exception{
			audioStream = AudioSystem.getAudioInputStream(song);
			clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        clip.start(); // starts playing the .wav file

    }
	public static void stop() {
		clip.stop();
	}
}
