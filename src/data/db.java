package data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import main.menu;

import java.sql.Connection;

public class db {
	
	private static Connection con;
	
	public static void connect() {
		if (con != null) return;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1:3306/appdb";
		try {
			con = DriverManager.getConnection(url, "", "");
			System.out.println("[DB] Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void disconnect() {
		if (con != null) {
			try {
				con.close();
				System.out.println("[DB] Disconnected");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cant close connection");
				e.printStackTrace();
			}
		}
	}
	
	public static boolean checkCreds(String inputU, String inputP) {
		String sql="SELECT password FROM accounts WHERE username=?";		
		try {
			PreparedStatement checkStmt = con.prepareStatement(sql);
			checkStmt.setString(1, inputU);
			ResultSet rs = checkStmt.executeQuery();
			if(rs.next()) {
				String passRetrieved = rs.getString("password");
				if (passRetrieved.equals(inputP))return true;
				return false;
			} return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error acessing database");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static void logLogin(String username, String time) {
		String sql = "INSERT INTO accounts_logs (username, time) VALUES (?,?)";
		try {
			PreparedStatement checkStmtLog = con.prepareStatement(sql);
			checkStmtLog.setString(1, username);
			checkStmtLog.setString(2, time);
			checkStmtLog.execute();
		} catch (SQLException e) {
			System.out.println("Error Logging login");
			e.printStackTrace();
		}
	}
	
	public static void createUser(String username, String password) {
		db.connect();
		String sql = "INSERT INTO accounts (username, password) VALUES (?,?)";
		try {
			PreparedStatement checkStmtLog = con.prepareStatement(sql);
			checkStmtLog.setString(1, username);
			checkStmtLog.setString(2, password);
			checkStmtLog.execute();
		} catch (SQLException e) {
			System.out.println("[ACC] Error trying to create users");
			e.printStackTrace();
		}
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// log the login time 

			}
		};			
		timer.schedule(task, 2000);
	}
	
	public static void getUsers() {
		db.connect();
        String sql = "select * from accounts";
        try{
			PreparedStatement checkStmtLog = con.prepareStatement(sql);

            ResultSet rs = checkStmtLog.executeQuery();
//            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){}
	}
	
}
