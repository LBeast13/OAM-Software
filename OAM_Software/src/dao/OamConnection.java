package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * The OamConnection class follows the singleton pattern in order
 * to have a single Connection object to access the database.
 * 
 * @author Liam
 *
 */
public class OamConnection {
	
	/**
	 * The URL for the database connection
	 */
	private String url = "jdbc:postgresql://localhost:5432/Test";
	
	/**
	 * Username to access the database.
	 */
	private String user = "postgres";
	
	/**
	 * Password to access the database.
	 */
	private String passwd = "";
	
	/**
	 * The Connection object
	 */
	private static Connection connect;

	/**
	 * Private constructor
	 */
	private OamConnection(){
		try {
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * This method will return the instance of OamConnection or will create it if
	 * the instance does not exist yet.
	 * 
	 * @return a Connection object
	 */
	public static Connection getInstance(){
		if(connect == null){
			new OamConnection();
		}
		return connect;   
	}   
}
