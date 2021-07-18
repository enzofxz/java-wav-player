import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class PlayerManager {
	static AudioInputStream audioStream; // creates a clip and a audioinputstream to play the wav file
    static Clip clip;
    
	public static void play(File song){
		try {
			audioStream = AudioSystem.getAudioInputStream(song);
			clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        clip.start(); // starts playing the .wav file
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
			        null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
		}

    }
	public static void stop() {
		clip.stop();
	}
}
