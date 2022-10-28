package data;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class csv {
	
	public static List<String[]> readAllLines(Path filePath) throws Exception {
	    try (Reader reader = Files.newBufferedReader(filePath)) {
	        try (CSVReader csvReader = new CSVReader(reader)) {
	            return csvReader.readAll();
	        }
	    }
	}
	
	
	public static void readData(String filePath) {
		CSVReader reader = null;
		String[] nextLine;

//		try {
//			reader = new CSVReader(new FileReader("src/Databases/accounts.csv"));
//			while ((nextLine = reader.readNext()) != null) {
//				for (String token: nextLine) {
//					System.out.println(token);
//				}
//				System.out.println();
//
//			}
//		} catch (Exception e) { 
//			System.out.println("[DB] Erorr trying to read database");
//			e.printStackTrace();
//		}
		
		try (BufferedReader br = new Buffered) {
		
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
