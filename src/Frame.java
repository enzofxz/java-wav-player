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
    	JButton button = new JButton("Play");
    	JFrame frame = new JFrame();
    	frame.setLocationRelativeTo(null);
        frame.setSize(320,160);
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
    				
    				//returnval = 0 if a file is selected and 1 if it is not. It's used on the try/catch statement down below
    				int returnVal = fc.showOpenDialog(frame); 
    				System.out.println(returnVal);
    				File file = fc.getSelectedFile();

    				try {
						PlayerManager.play(file);
	    				JOptionPane.showMessageDialog(frame, "Song being played.\nPress OK to return");
	    				PlayerManager.stop();
					} catch (Exception e1) {
						// a file was selected
						if(returnVal==0) {
							JOptionPane.showMessageDialog(
							        frame, "Unsupported extension\nPlease choose a .wav file", "Error", JOptionPane.ERROR_MESSAGE);
						}
						// a file was not selected
						else {
							JOptionPane.showMessageDialog(
							        frame, "Please select a file", "Failure", JOptionPane.ERROR_MESSAGE);
						}

					}
    			}
        	};
        	button.addActionListener(buttonListener);
    }
}
