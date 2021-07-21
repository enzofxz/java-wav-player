import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Frame {
    public void initialFrame() {
    	//creating and setting the frame and the button settings.
    	JFrame frame = new JFrame();
        JButton button = new JButton("Play");
        frame.setSize(640,480);
        frame.setTitle(".WAV player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(button);
        frame.setVisible(true);
        
        //setting up the button to call the methods on PlayerManager.java that plays/stops the song when the button is pressed.
            ActionListener buttonListener = new ActionListener() { 
        		
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				//creates a JFileChooser object to select the .wav file from file explorer
    		    	final JFileChooser fc = new JFileChooser(); 
    		    	
    		    	//creates a FileNameExtensionFilter object to show only .wav files
    				FileNameExtensionFilter filter = new FileNameExtensionFilter(".wav files", "wav");
    				
    				//passes the wav filter to the file chooser
    				fc.setFileFilter(filter);
    				
    				int returnVal = fc.showOpenDialog(frame);
    				File file = fc.getSelectedFile();

    				try {
						PlayerManager.play(file);
	    				JOptionPane.showMessageDialog(frame, "Song being played.\nPress OK to return");
	    				PlayerManager.stop();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(
						        frame, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
					}
    			}
        	};
        	button.addActionListener(buttonListener);
    }
}
