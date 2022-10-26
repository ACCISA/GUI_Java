package main;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

import accountMenu.account;

public class menu extends JFrame implements ActionListener{

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
	ImageIcon loadIcon;
	ImageIcon saveIcon;
	ImageIcon exitIcon;
	ImageIcon logo;
	
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
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		resetItem.addActionListener(this);
		usersItem.addActionListener(this);
		
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
		
		menuBar.add(fileMenu);
		menuBar.add(accountMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);		
		
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loadItem ) { // find which menu item was called
			System.out.println("fileloaded");
		}
		if(e.getSource() == saveItem ) { // find which menu item was called
			System.out.println("save");
		}
		if(e.getSource() == exitItem ) { // find which menu item was called
			System.exit(0);
		}
		if(e.getSource() == resetItem) {
			creds_reset.initialize();
		}
		if(e.getSource() == usersItem) {
			account.addUser();
		}
	}

}
