import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class popup implements ActionListener {

	private static JFrame frame;
	private static JLabel msgLabel;
	private static JPanel panel;
	private static JButton okBtn;
	
	public static void createPopup(String title, String message) {
		
		int popLen = message.length() * 10; // multiply to fit the message in the popup
		int popHei = message.length() * 10; 
		
		panel = new JPanel();
		frame = new JFrame();
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(func.getWidth()/2-popHei,func.getHeight()/2-popLen);
		frame.setResizable(false);
		frame.setSize(popLen*2,100);
		frame.add(panel);
		
	
		
		msgLabel = new JLabel(message);
		msgLabel.setBounds(100,100,popLen,popHei);
		panel.add(msgLabel);
		
		okBtn = new JButton("Ok");
		okBtn.setBounds(100,130,popLen,popHei);
		okBtn.addActionListener(new popup());
		panel.add(okBtn);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}

}
