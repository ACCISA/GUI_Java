package data;
import java.io.FileWriter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class csv {
	
	public static void readAllLines(Path filePath){
	    try {
	    	Scanner scanner = new Scanner(filePath.toFile());
	    	scanner.useDelimiter(",");
	    	while(scanner.hasNext()) {
	    		System.out.println(scanner.next() + " ");
	    	}
	    	scanner.close();
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
	

	
	
	
	public static void checkCreds(String username, String password) {
		
	}
	
	public static void createDatabase() {
		File dbPath = new File("src/Databases/accounts.csv");
		
		if (dbPath.isFile()) {
			System.out.println("[DB] Database Found"); 
			return;
		}
		
		try {
			System.out.println("[DB] Database Not Found");
			System.out.println("[DB] Database Create");
	        CSVWriter csvWriter = new CSVWriter(new FileWriter("src/Databases/accounts.csv"));
	        csvWriter.writeNext(new String[]{"Name", "Password"});
	        csvWriter.writeNext(new String[]{"admin", "root"});


	 
	        csvWriter.close();		
		} catch (IOException e) {
			System.out.println("[Data] Error while trying to create databases");
			e.printStackTrace();
		}

	}
	
	

}
