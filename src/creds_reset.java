import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static JFrame frame;
	private static JLabel user;
	private static JLabel pass1;
	private static JLabel pass2;

	
	public static void reset(String username, String password) {		
		
	}
	
	public static void initialize() {
		
		
		JPanel panel = new JPanel();
		
		ImageIcon image = new ImageIcon("conco_logo.png");

		
		frame = new JFrame();
		frame.setSize(500,200);
		frame.setTitle("Reset Credentials");
		frame.setIconImage(image.getImage());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(func.getWidth()/2-350/2, func.getHeight()/2-400/2);
		frame.add(panel);
		
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
		
		frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		String newUser = updateUser.getText();
		String newPass = updatePass.getText();
		String newPassDupe = updatePassDupe.getText();
		int funcReturn = func.checkUpdatedCreds(newUser, newPass, newPassDupe);
		if ( funcReturn == 0) {
			System.out.println("Credentials Updated");
			popup.createPopup("Warning", "Credentials have been updated.");
		} else if( funcReturn == 1 ) {
			System.out.println("Inputted passwords do not match");
			popup.createPopup("Warning", "Passwords do not match.");
		} else if( funcReturn == 2 ) {
			System.out.println("Inputted credentials match old credentials");
			popup.createPopup("Warning", "Credentials amtch old credentials.");
		} else {
			System.out.println("An error occured when trying to set new credentials");
		}
		
		frame.dispose();
	}
	
}
