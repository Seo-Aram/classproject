package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/project";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, "scott", "test1234");
			
			if(conn != null) {
				System.out.println("DB연결 성공");
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM DEPT");
				
				while(rs.next()) {
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					System.out.println(deptno + dname);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
