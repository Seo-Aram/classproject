package dept.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static String dbUrl = "jdbc:mysql://localhost:3306/project";
	private static String dbId = "scott";
	private static String dbPw = "test1234";
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
		return conn;
	}
	
}
