import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayerManager {
	static AudioInputStream audioStream; 
    static Clip clip;
    
	public static void play(File song) throws Exception{
		audioStream = AudioSystem.getAudioInputStream(song);
		clip = AudioSystem.getClip();
	    clip.open(audioStream);
	    clip.start(); 

    }
	//it stops if the song is running and resumes if it is not
	public static void stopresume() {
		if(clip.isRunning()) {
			clip.stop();
		}
		else {
			clip.start();
		}

	}
}
