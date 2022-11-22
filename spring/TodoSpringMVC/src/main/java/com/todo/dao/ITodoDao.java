package com.todo.dao;

import com.todo.module.sign.LoginInfo;
import com.todo.module.todo.TodoData;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ITodoDao {
    public void insertTodo(Connection conn, String title, String date, LoginInfo loginInfo) throws SQLException;

    public List<TodoData> selectTodoList(Connection conn, LoginInfo loginInfo) throws SQLException;

    public TodoData selectData(Connection conn, long key, LoginInfo loginInfo) throws SQLException;

    public void updateData(Connection conn, TodoData data, LoginInfo loginInfo) throws SQLException;

    public void deleteData(Connection conn, long key, LoginInfo loginInfo) throws SQLException;
}
