package com.todo.dao;

import com.todo.module.todo.TodoData;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface ITodoDao {
    public void insertTodo(Connection conn, String title, String date) throws SQLException;

    public List<TodoData> selectTodoList(Connection conn) throws SQLException;

    public TodoData selectData(Connection conn, long key) throws SQLException;

    public void updateData(Connection conn, TodoData data) throws SQLException;

    public void deleteData(Connection conn, long key) throws SQLException;
}
