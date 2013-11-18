package phms_se.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author: Yi Hsiang
 */
public class ConnectionManager
{
	//initialize the static variable - instance and set it to null 
	private static ConnectionManager instance = null;

	//all connection credentials set here
	//change the USERNAME and PASSWORD here to allow it to connect to any local database
	private final String USERNAME = "precision";
	private final String PASSWORD = "rocks";
	private final String connectionStr =
			"jdbc:hsqldb:file:data/phms;shutdown=true";

	//declare a private connection object and set it to null for now
	private Connection conn = null;

	//empty constructor but all necessary credentials are already hard-coded
	//notice the constructor is private, this means that it can only be called from within
	//the class itself, along with the private static ConnectionManager instance object variable
	//we can ensure that we are passing out a single reference to this connection throughout the 
	//entire lifetime of the application, and every method/class within the application
	//that needs connection to the database would be using the this connection.
	private ConnectionManager() {
		
	}

	//notice this is the entry point to create the database connection
	//the code checks if there's already an existing ConnectionManager instance, if there is one
	//it returns the static ConnectionManager instance
	//otherwise, it will call the private connectionManager constructor to initialize all private variables.
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	//open the connection to the database, only called once during the life-time of the app session
	//establish the actual connection here.
	private boolean openConnection()
	{
		try {
			System.out.println("about to open the connection");
			conn = DriverManager.getConnection(connectionStr, USERNAME, PASSWORD);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Unable to connect\nCause: "+e.getCause());
			System.out.println(e);
			return false;
		} 
	}

	//this is the method to call when a method or class need to communicate with the database.
	//this method calls the openConnection() to establish a connection if it does not already exist.
	//otherwise, it returns the reference to the connection object declared above.
	
	//Also note that this method is public but non static, which means we need a instance of this class
	//in order to use this, this class does not have public constructor, therefore, it will only have
	// the private static instance declared above, to call this method we have to do the following..
	//ConnectionManager.getInstance().getConnection()
	public Connection getConnection()
	{
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Connection opened");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	//close the connection
	public void close() {
		System.out.println("Closing connection");
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
		}
	}
}