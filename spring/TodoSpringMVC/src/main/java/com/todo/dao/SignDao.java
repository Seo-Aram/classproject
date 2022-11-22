package com.todo.dao;

import com.todo.module.sign.Member;
import com.todo.module.sign.MemberRegRequest;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Repository
public class SignDao {
    public Member signInByIdPw(Connection conn, String id, String pw) throws SQLException {
        Member member = null;

        String sql = "select * from todo_member where user_id = ? and password = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            member = new Member(
                    rs.getLong("idx"),
                    rs.getString("uuid"),
                    rs.getString("user_id"),
                    rs.getString("password"),
                    rs.getString("profile_url")
            );
        }

        return member;
    }

    public int signUp(Connection conn, Member member) throws SQLException {
        String sql = "insert into todo_member(user_id, password) values(?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, member.getId());
        pstmt.setString(2, member.getPw());

        return pstmt.executeUpdate();
    }

    public int updateProfileImg(Connection conn, String imgURI, String userId) throws SQLException {
        String sql = "update todo_member set profile_url = ? where user_id = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, imgURI);
        pstmt.setString(2, userId);

        return pstmt.executeUpdate();
    }
}
