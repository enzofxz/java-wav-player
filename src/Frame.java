import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Frame {
    public void initialFrame() {    
    	
    	//creates and sets the frame and components settings
    	JFrame frame = new JFrame();
		frame.setTitle(".wav Player");
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton play = new JButton("Select New Song");
		frame.getContentPane().add(play);
		
		JButton pauseresume = new JButton("Pause/Resume");
		frame.getContentPane().add(pauseresume);
		
		JTextField currentlystate = new JTextField();
		currentlystate.setFont(new Font("Dialog", Font.PLAIN, 12));
		currentlystate.setText("No file selected");
		currentlystate.setHorizontalAlignment(JTextField.CENTER);
		currentlystate.setColumns(17);
		currentlystate.setEditable(false);
		frame.getContentPane().add(currentlystate);
		
		frame.setBounds(100, 100, 193, 131);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
        
       
            ActionListener playListener = new ActionListener() {     		
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				//opens the file chooser and applies a wav filter
    		    	final JFileChooser fc = new JFileChooser();     		    	
    				FileNameExtensionFilter filter = new FileNameExtensionFilter(".wav files", "wav");
    				fc.setFileFilter(filter);
    				
    				//returnval = 0 if a file is selected and 1 if it is not. It's used in the try/catch down below
    				int returnVal = fc.showOpenDialog(frame); 
    				File file = fc.getSelectedFile();
    				
    				try {
						PlayerManager.play(file);
						currentlystate.setText("File: "+file.getName());
						
					} catch (Exception e1) {
						
						// if a file was selected
						if(returnVal==0) {
							JOptionPane.showMessageDialog(
							        frame, "Unsupported extension\nPlease choose a .wav file", "Error", JOptionPane.ERROR_MESSAGE);
						}
						// if a file was not selected
						else {
							JOptionPane.showMessageDialog(
							        frame, "Please select a file", "Failure", JOptionPane.ERROR_MESSAGE);
						}
					}
    			}
        	};
        	play.addActionListener(playListener);
        	
        	ActionListener pauseresumeListener = new ActionListener() {
        		@Override
        		public void actionPerformed (ActionEvent e) {
        			try {
            			PlayerManager.stopresume();
        			}catch(Exception e1) {
        				JOptionPane.showMessageDialog(
						        frame, "Please select a file", "Failure", JOptionPane.ERROR_MESSAGE);
        			}

        		}
        	};
        	pauseresume.addActionListener(pauseresumeListener);
    }
}
