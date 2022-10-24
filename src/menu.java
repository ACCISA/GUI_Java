import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;

public class menu {

	private static JFrame frame;
	private static JPanel panel;
	
	public static void initialize() {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(func.getWidth(), func.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		
		frame.setVisible(true);
	}


}
