package dao;

import lombok.Cleanup;
import module.Member;

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

    public Member signInByUUID(Connection conn, String uuid) throws SQLException {
        Member member = null;

        String query = "select * from todo_member where uuid = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, uuid);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            member = Member.builder()
                    .id(rs.getString("id"))
                    .idx(rs.getLong("idx"))
                    .pw(rs.getString("password"))
                    .uuid(rs.getString("uuid"))
                    .build();
        }

        return member;
    }

    public void updateUUIDByIdx(Connection conn, long idx, String uuid) throws SQLException {
        String query = "update todo_member set uuid = ? where idx = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, uuid);
        pstmt.setLong(2, idx);
        pstmt.executeUpdate();

    }
}
