package source;
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
public class login implements ActionListener {

	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	private static JFrame frame;
	
	int loginCount = 0;
	
	public static void main(String[] args) {		
		
		// make sure the credential file exists
		func.checkCredsFileExist();
		
		JPanel panel = new JPanel();
		
		ImageIcon image = new ImageIcon("conco_logo.png");
		
		frame = new JFrame();
		frame.setSize(350, 200);
		frame.setIconImage(image.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(func.getWidth()/2-350/2, func.getHeight()/2-200/2);
		frame.add(panel);
		
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
		
		frame.setVisible(true);

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		loginCount++;
		if (loginCount > 1) {return;} // prevent from clicking login multiple time during 2 second timer
		
		
		
		String user = userText.getText();
		String password = passwordText.getText();

		if (!(func.checkCreds(user, password))) {
			success.setText("Invalid Credentials");
			userText.setText("");
			passwordText.setText("");
		} else {
			success.setText("Login successfull");
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					frame.dispose();
					menu.initialize();
				}
			};			
			timer.schedule(task, 2000);
		}	
	}
}
