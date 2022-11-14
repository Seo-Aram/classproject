package dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignDao {
    public boolean signIn(Connection conn, String id, String password) throws SQLException {
        boolean result = false;

        String query = "select * from todo_member where id = ? and password = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, id);
        pstmt.setString(2, password);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()) result = true;

        return result;
    }
}
