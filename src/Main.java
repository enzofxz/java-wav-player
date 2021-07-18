
	import java.io.File;
	import java.io.IOException;
	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;
	import javax.sound.sampled.LineUnavailableException;
	import javax.sound.sampled.UnsupportedAudioFileException;
	import java.util.Scanner;

	public class Main {
	    public Main() {
	    }

	    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
	        File musica = new File("musica.wav");
	        play(musica);
	    }

	    public static void play(File musicpath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	        Scanner in = new Scanner(System.in);
	    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicpath);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        clip.start();
	        in.next();
	    }
	}


