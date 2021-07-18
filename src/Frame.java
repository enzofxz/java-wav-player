import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

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
    				File file = new File("musica.wav");
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
