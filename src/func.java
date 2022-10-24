import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class func {
	
	private static Dimension size;
	
	public static int getWidth() {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)size.getWidth();
		return width;
	}
	
	public static int getHeight() {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)size.getHeight();
		return height;
	}
	
	public static boolean checkCreds(String username, String password) {
		if (!(username.equals("A") && password.equals("C"))) return false;			
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();		
	    // create the file if it does not exists
	    try {
	    	File myObj = new File ("login_data.txt");
	    	if (myObj.createNewFile()) {
	    		System.out.println("File created: " + myObj.getName());
	    	} else {
	    		System.out.println("File  Already Exists");
	    	}
	    	
	    } catch (IOException e) {
	    	System.out.println("An error occurred while trying to create the file.");
	    	e.printStackTrace();
	    }
	    
	    //read the file before writing to it. If you find how to write without wiping existing data lmk
	    String data = "";
    	ArrayList<String> dataList = new ArrayList<>();	    	

	    try {
	    	File objFile = new File("login_data.txt");
	    	Scanner reader = new Scanner(objFile);
	    	while (reader.hasNextLine()) {
	    		 data = reader.nextLine();
	    		 dataList.add(data);
	    		 System.out.println(data);
	    	}
	    	reader.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("An error occured when trying to read the login_data file.");
	    	e.printStackTrace();
	    }
	    
	    // write to the file
	    try {
	    	FileWriter writer = new FileWriter("login_data.txt");
	    	if (data.length() == 0) {
		    	writer.write("user: " + username + "; password: " + password + "; time: " + dtf.format(now));
		    	System.out.println("File login_data was empty, data added.");
		    	writer.close();
	    	} else {
	    		
	    		String allData = "";
	    		for (int i = 0; i < dataList.size(); i++) {
	    			String curData = dataList.get(i);
	    			allData += curData + "\n";
	    		}
		    	writer.write(allData + "user: " + username + "; password: " + password + "; time: " + dtf.format(now));
		    	System.out.println("File login_data, data added.");
		    	writer.close();
	    	}
	    } catch (IOException e) {
	    	System.out.println("An error occured while trying to write data to the file.");
	    	e.printStackTrace();
	    }
	    
		return true;
		
		
	}
	
	
}
