package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;

public class creds_reset implements ActionListener{
	
	private static JLabel showInfo;
	private static JLabel updateInfo;
	private static JTextField updateUser;
	private static JPasswordField updatePass;
	private static JPasswordField updatePassDupe;
	private static JButton buttonUpdate;
	public static JFrame frameCredsReset;
	private static JLabel user;
	private static JLabel pass1;
	private static JLabel pass2;

	
	public static void reset(String username, String password) {		
		
	}
	
	public static void initialize() {
		
		
		
		JPanel panel = new JPanel();
		
		ImageIcon image = new ImageIcon("src/images/conco_logo.png");
		
		frameCredsReset = new JFrame();
		frameCredsReset.setSize(500,200);
		frameCredsReset.setAlwaysOnTop(true);
		
		frameCredsReset.setTitle("Reset Credentials");
		frameCredsReset.setIconImage(image.getImage());

		frameCredsReset.setLocation(func.getWidth()/2-350/2, func.getHeight()/2-400/2);
		frameCredsReset.add(panel);
		
		panel.setLayout(null);
		
		showInfo = new JLabel("Insert New Credentials");
		showInfo.setBounds(150,5,160,25);
		panel.add(showInfo);
		
		updateUser = new JTextField();
		updateUser.setBounds(180,40,165,25);
		panel.add(updateUser);
		
		updatePass = new JPasswordField();
		updatePass.setBounds(180,70,165,25);
		panel.add(updatePass);
		
		updatePassDupe = new JPasswordField();
		updatePassDupe.setBounds(180,100,165,25);
		panel.add(updatePassDupe);
				
		user = new JLabel("New Username:");
		user.setBounds(10,40,140,25); 
		panel.add(user);

		pass1 = new JLabel("New Password:");
		pass1.setBounds(10,70,140,25);
		panel.add(pass1);
		
		pass2 = new JLabel("Confirm Password:");
		pass2.setBounds(10,100,140,25);
		panel.add(pass2);
		
		buttonUpdate = new JButton("Update Credentials");
		buttonUpdate.setBounds(150,130,160,25);
		buttonUpdate.addActionListener(new creds_reset());
		panel.add(buttonUpdate);
		
		frameCredsReset.setVisible(true);
		
			
	}

	public void actionPerformed(ActionEvent e) {
		
		String newUser = updateUser.getText();
		String newPass = updatePass.getText();
		String newPassDupe = updatePassDupe.getText();
		frameCredsReset.setAlwaysOnTop(false);
		int funcReturn = func.checkUpdatedCreds(newUser, newPass, newPassDupe);
		
		if ( funcReturn == 0) {
			System.out.println("Credentials Updated");
			popup.createPopup("Warning", "Credentials have been updated.",frameCredsReset);
			frameCredsReset.dispose();
			menu.state = true;

		} else if( funcReturn == 1 ) {
			System.out.println("Inputted passwords do not match");
			popup.createPopup("Warning", "Passwords do not match.",frameCredsReset);
		} else if( funcReturn == 2 ) {
			System.out.println("Inputted credentials match old credentials");
			popup.createPopup("Warning", "Credentials match old credentials.",frameCredsReset);
		} else if(funcReturn == 3) { 
			System.out.println("No Input");
			popup.createPopup("Warning", "Please input valid information" , frameCredsReset);
		}else {
			System.out.println("An error occured when trying to set new credentials");
		}
		
	}	
}
