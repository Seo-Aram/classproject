package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/project";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, "scott", "test1234");
			
			if(conn != null) {
				System.out.println("DB연결 성공");
				
				pstmt = conn.prepareStatement("INSERT INTO DEPT VALUES(?, ?, ?)");
				pstmt.setInt(1, 50);
				pstmt.setString(2, "DEVELOPER");
				pstmt.setString(3, "SEOUL");
				
				int result = pstmt.executeUpdate();
				System.out.println(result);
				
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
