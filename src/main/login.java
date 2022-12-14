package main;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;
public class login implements ActionListener {

	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	private static JFrame frameLogin;
	
	int loginCount = 0;
	
	public static void main(String[] args) {		
		
//		data.csv.createDatabase();
//		Path filePath =  Paths.get("src/Databases/accounts.csv");
//		data.csv.readAllLines(filePath);

		// make sure the credential file exists
//		func.checkCredsFileExist();
		
		JPanel panel = new JPanel();
		
		ImageIcon image = new ImageIcon("src/images/conco_logo.png");
		
		frameLogin = new JFrame();
		frameLogin.setSize(350, 200);
		frameLogin.setIconImage(image.getImage());
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setResizable(false);
		frameLogin.setLocation(func.getWidth()/2-350/2, func.getHeight()/2-200/2);
		frameLogin.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(140,110,80,25);
		button.addActionListener(new login());
		panel.add(button);

		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);
		
		frameLogin.setVisible(true);

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		data.db.connect();
		loginCount++;
		if (loginCount > 1) {return;} // prevent from clicking login multiple time during 2 second timer
		
		
		
		String user = userText.getText();
		String password = passwordText.getText();
		
		if (!(data.db.checkCreds(user, password))) {
			success.setText("Invalid Credentials");
			userText.setText("");
			passwordText.setText("");
		} else {
			success.setText("Login successfull");
			String curTime = func.getTime();
			data.db.logLogin(user, curTime);
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					frameLogin.dispose();
					// log the login time
					
					new menu();
				}
			};			
			timer.schedule(task, 2000);
		}	
	}
}
