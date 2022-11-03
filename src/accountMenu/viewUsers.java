package accountMenu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.func;

import javax.swing.JTable;

public class viewUsers {
	
	public static JFrame frame;
	private static JPanel panel;
	private static JTable dataTable;
	
	
	public static void viewUsers() {

		ImageIcon image = new ImageIcon("src/images/conco_logo.png");
		panel = new JPanel();
		frame = new JFrame();
		frame.setTitle("View Users");
		frame.setSize(600,800);
		frame.setIconImage(image.getImage());
		frame.setResizable(false);
		frame.setLocation(func.getWidth()/2-500/2, func.getHeight()/2-250/2);
		frame.setAlwaysOnTop(true);
		frame.add(panel);
		
		panel.setLayout(null);
		String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
	    String y[][] = new String[40][8];
		dataTable = new JTable(y,x);
		panel.add(dataTable);
//		dataTable.setmode
		
		frame.setVisible(true);
		
	}
}
