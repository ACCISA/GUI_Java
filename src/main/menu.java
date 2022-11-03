package main;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

import accountMenu.account;
import accountMenu.viewUsers;

public class menu extends JFrame implements ActionListener{


	public static boolean state = true;

	
	JMenuBar menuBar;
	JMenu accountMenu;
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	JMenuItem resetItem;
	JMenuItem usersItem;
	JMenuItem viewUsersItem;
	ImageIcon loadIcon;
	ImageIcon saveIcon;
	ImageIcon exitIcon;
	ImageIcon logo;
	JFrame frameObj;
	
	
	menu(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		logo = new ImageIcon("src/images/conco_logo.png");
		this.setIconImage(logo.getImage());
		loadIcon = new ImageIcon("src/images/load.png");
		saveIcon = new ImageIcon("src/images/save.png");
		exitIcon = new ImageIcon("src/images/exit.png");
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		accountMenu = new JMenu("Account");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		
		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");	
		resetItem = new JMenuItem("Reset Credentials");
		usersItem = new JMenuItem("Add Users");
		viewUsersItem = new JMenuItem("View Users");
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		resetItem.addActionListener(this);
		usersItem.addActionListener(this);
		viewUsersItem.addActionListener(this);
		
		loadItem.setIcon(loadIcon);
		saveItem.setIcon(saveIcon);
		exitItem.setIcon(exitIcon);
		
		
		loadItem.setMnemonic(KeyEvent.VK_L); // l for load
		saveItem.setMnemonic(KeyEvent.VK_S);
		exitItem.setMnemonic(KeyEvent.VK_E);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		helpMenu.setMnemonic(KeyEvent.VK_H);

		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		accountMenu.add(resetItem);
		accountMenu.add(usersItem);
		accountMenu.add(viewUsersItem);
		
		menuBar.add(fileMenu);
		menuBar.add(accountMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);		
		
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int eventCaller = 0;
		
		if (e.getSource() == viewUsersItem) {
			System.out.println("Opening view users");
			viewUsers.viewUsers();
		}
		if (e.getSource() == exitItem) System.exit(0);
		if (e.getSource() == loadItem) eventCaller = 1;
		if (e.getSource() == saveItem) eventCaller = 2;
		if (e.getSource() == resetItem) eventCaller = 3;
		if (e.getSource() == usersItem) eventCaller = 4;
		
		
		JMenuItem menuObj = null;
		switch (eventCaller) {
			case 1:
				System.out.println("fileloaded");
				menuObj = loadItem;
				break;
			case 2:
				System.out.println("save");
				menuObj = saveItem;
				break;
			case 3:
				menuObj = resetItem;
				break;
			case 4:
				menuObj = usersItem;
				break;
			default:
				System.out.println("Error trying to open menu item");
				break;
			
		}
		
		if (menuObj.isVisible()) System.out.println("is visible");
		if (!(menuObj.isVisible())) System.out.println("is visible");

		if (frameObj != null) {
			if (!(frameObj.isActive())) {
				return;
			}
			System.out.println("frame is not active");
			state = true;
		}
		if (state == false && menuObj.isVisible()) return;		

		switch (eventCaller) {
			case 1:
				state = false;
				break;
			case 2:
				state = false;
				break;
			case 3:
				state = false;
				creds_reset.initialize();
				frameObj = creds_reset.frameCredsReset;
				break;
			case 4:
				state = false;
				account.addUser();
				frameObj = account.frame;
				break;
		}	
	}

}
