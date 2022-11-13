package controller.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import module.todo.TodoData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class TodoListDao {
    public void insertTodo(Connection conn, String title, String date) throws SQLException {
        String query = "insert into todo_list(title, date) value(?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, title);
        pstmt.setString(2, date);
        int result = pstmt.executeUpdate();

        log.debug(title, date,  result);

        //return result;
    }

    public List<TodoData> selectTodoList(Connection conn) throws SQLException {
        String query = "select * from todo_list";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoData> list = new ArrayList<>();
        while(rs.next()) {
            list.add(new TodoData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }

        return list;
    }

    public TodoData selectData(Connection conn, long key) throws SQLException {
        String query = "select * from todo_list where todo_id = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setLong(1, key);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        TodoData data = null;
        if(rs.next()) {
            data = new TodoData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
        }

        return data;
    }

    public void updateData(Connection conn, TodoData data) throws SQLException {
        String query = "update todo_list set title = ?, date = ?, isCheck = ? where todo_id = ?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, data.getTitle());
        pstmt.setString(2, data.getDate());
        pstmt.setBoolean(3, data.isCheck());
        pstmt.setLong(4, data.getKey());

        pstmt.executeUpdate();
    }

    public void deleteData(Connection conn, long key) throws SQLException {
        String query = "delete from todo_list where todo_id = ?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setLong(1, key);
        pstmt.executeUpdate();
    }
}
