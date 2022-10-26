package accountMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.func;
import main.menu;
import main.popup;


public class account implements ActionListener {

	public static JFrame frame;
	private static JPanel panel;
	private static JTextField inputUser;
	private static JPasswordField inputPass;
	private static JPasswordField inputPassDupe;
	private static JLabel userLabel;
	private static JLabel passLabel;
	private static JLabel passDupeLabel;
	private static JButton create;
	
	public static void addUser() {
		
		
		ImageIcon image = new ImageIcon("src/images/conco_logo.png");
		panel = new JPanel();
		frame = new JFrame();
		frame.setTitle("Account Creation");
		frame.setSize(400,220);
		frame.setIconImage(image.getImage());
		frame.setResizable(false);
		frame.setLocation(func.getWidth()/2-500/2, func.getHeight()/2-250/2);
		frame.setAlwaysOnTop(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		inputUser = new JTextField();
		inputUser.setBounds(180,10,165,25);
		inputPass = new JPasswordField();
		inputPass.setBounds(180,60,165,25);
		inputPassDupe = new JPasswordField();
		inputPassDupe.setBounds(180,110,165,25);
		
		userLabel = new JLabel("Username: ");
		userLabel.setBounds(50,10,80,25);
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(50,60,80,25);
		passDupeLabel = new JLabel("Confirm Password: ");
		passDupeLabel.setBounds(40,110,120,25);
		

		create = new JButton("Create Account");
		create.setBounds(90,140,160,25);
		create.addActionListener(new account());
		
		panel.add(inputUser);
		panel.add(inputPass);
		panel.add(inputPassDupe);
		panel.add(userLabel);
		panel.add(passLabel);
		panel.add(passDupeLabel);
		panel.add(create);
		
		frame.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String user = inputUser.getText();
		String pass = inputPass.getText();
		String passDupe = inputPassDupe.getText();
		
		
		boolean canContinue = true;
		if (user.length() == 0 || pass.length() == 0 || passDupe.length() == 0) {
			frame.setAlwaysOnTop(false);
			popup.createPopup("Warning", "Please enter a valid information.",frame);
			canContinue = false;
		}
		
		if (!(pass.equals(passDupe))) {
			frame.setAlwaysOnTop(false);
			popup.createPopup("Warning", "Passwords do no match",frame);
			canContinue = false;
		}
		
		if (canContinue) {
			System.out.println("Account Creation Started");
			frame.dispose();
			menu.state = true;
		}
		
		// create a function to check if the user already exists
	}
	
}
