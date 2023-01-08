/**
 * 
 */
package recipes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import recipes.exception.DbException;

/**
 * @author Nathan.Whitman
 *
 */
public class DbConnection {
 private static final String SCHEMA = "videorecipes";
 private static final String USER = "classrecipes";
 private static final String PASSWORD = "recipes";
 private static final String HOST = "localhost";
 private static final int PORT = 3306;
 
 // create a method to create a new connection every time we call it
 
 public static Connection getConnection() {
	 String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
	 System.out.println("Connecting with url= " + url);
	 

	 try {
		Connection conn = DriverManager.getConnection(url);
		System.out.println("Successfully obtained connection!");
		return conn;
	} catch (SQLException e) {
		throw new DbException(e);
	}
 }
}
