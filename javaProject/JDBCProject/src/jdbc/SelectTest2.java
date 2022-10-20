package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/project";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, "scott", "test1234");
			
			if(conn != null) {
				System.out.println("DB연결 성공");
				
				pstmt = conn.prepareStatement("SELECT * FROM DEPT WHERE deptno = ?");
				pstmt.setInt(1, 10);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
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
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
