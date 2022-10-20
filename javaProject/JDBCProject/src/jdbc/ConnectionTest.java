package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/project";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, "scott", "test1234");
			
			if(conn != null) {
				System.out.println("DB연결 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
