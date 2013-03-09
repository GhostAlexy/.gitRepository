package example.connection.to.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	private static String DBNAME;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	private static String DRIVER;
	// private static final String DBNAME = "facturafiscala";
	// private static final String URL = "jdbc:mysql://localhost:3306/";
	// private static final String USER = "root";
	// private static final String PASSWORD = "root";
	// private static final String DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	private static JDBCConnection connection = null;

	private JDBCConnection() {
		try {
			System.out.println("Incercare de gasire fisier...");
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"/config.properties");
			prop.load(in);
			System.out.println("Fisierul a fost incarcat cu success!!!");
			DBNAME = prop.getProperty("db_name");
			USER = prop.getProperty("db_username");
			PASSWORD = prop.getProperty("db_password");
			URL = prop.getProperty("db_url");
			DRIVER = prop.getProperty("db_driver");
		} catch (IOException ex) {
			System.out.println("Can not read property file...");
		}

		try {

			Class.forName(DRIVER);
			setCon(DriverManager.getConnection(URL + DBNAME, USER, PASSWORD));
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("There was something wrong with the database connection!!\n" + e.getMessage());
			System.exit(-1);
		}
		System.out.println("MySQL JDBC Driver Registered!");
	}

	public static JDBCConnection getConnection() {
		if (connection == null) {
			connection = new JDBCConnection();
		}
		return connection;
	}

	public Connection getCon() {
		return conn;
	}

	public void setCon(Connection conn) {
		this.conn = conn;
	}

	public void disconnect() {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Disconnected..");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
