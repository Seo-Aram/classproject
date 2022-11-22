package com.todo.dao;

import com.todo.module.sign.LoginInfo;
import com.todo.module.todo.TodoData;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Repository
public class TodoListDao implements ITodoDao {
    public void insertTodo(Connection conn, String title, String date, LoginInfo loginInfo) throws SQLException {
        String query = "insert into todo_list(todo_title, todo_date, user_id) value(?, ?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, title);
        pstmt.setString(2, date);
        pstmt.setString(3, loginInfo.getUserId());
        int result = pstmt.executeUpdate();

        log.debug(title, date,  result);
    }

    public List<TodoData> selectTodoList(Connection conn, LoginInfo loginInfo) throws SQLException {
        String query = "select * from todo_list where user_id = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, loginInfo.getUserId());
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoData> list = new ArrayList<>();
        while(rs.next()) {
            list.add(new TodoData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }

        return list;
    }

    public TodoData selectData(Connection conn, long key, LoginInfo loginInfo) throws SQLException {
        String query = "select * from todo_list where todo_id = ? and user_id = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setLong(1, key);
        pstmt.setString(2, loginInfo.getUserId());
        @Cleanup ResultSet rs = pstmt.executeQuery();

        TodoData data = null;
        if(rs.next()) {
            data = new TodoData(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
        }

        return data;
    }

    public void updateData(Connection conn, TodoData data, LoginInfo loginInfo) throws SQLException {
        String query = "update todo_list set todo_title = ?, todo_date = ?, finished = ? where todo_id = ? and user_id = ?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, data.getTitle());
        pstmt.setString(2, data.getDate());
        pstmt.setBoolean(3, data.isFinished());
        pstmt.setLong(4, data.getKey());
        pstmt.setString(5, loginInfo.getUserId());

        pstmt.executeUpdate();
    }

    public void deleteData(Connection conn, long key, LoginInfo loginInfo) throws SQLException {
        String query = "delete from todo_list where todo_id = ? and user_id = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setLong(1, key);
        pstmt.setString(2, loginInfo.getUserId());
        pstmt.executeUpdate();
    }
}
