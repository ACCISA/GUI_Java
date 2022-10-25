import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;

public class menu implements ActionListener {

	private static JFrame frame;
	private static JPanel panel;
	private static JButton resetCreds;
	private static JLabel resetInfo;
	
	public static void initialize() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(func.getWidth(), func.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		
		
		resetCreds = new JButton("Reset Creds");
		resetCreds.setBounds(100,110,80,25);
		resetCreds.addActionListener(new menu());
		panel.add(resetCreds);
		
		resetInfo = new JLabel("Reset Creds Here");
		resetInfo.setBounds(10,110,80,25);
		panel.add(resetInfo);
		
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// user wants to reset his credentials
		frame.dispose();
		creds_reset.initialize();
		
		
	}


}
