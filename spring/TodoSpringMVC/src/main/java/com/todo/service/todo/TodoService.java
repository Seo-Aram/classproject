package com.todo.service.todo;

import com.todo.dao.ITodoDao;
import com.todo.module.todo.TodoData;
import com.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;


@Service
public class TodoService {

    private final ITodoDao dao;

    public TodoService(ITodoDao dao) {
        this.dao = dao;
    }

    public List<TodoData> selectAllTodo() throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectTodoList(conn);
    }

    public TodoData selectTodoDataByKey(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectData(conn, key);
    }

    public void removeTodoDataByKey(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.deleteData(conn, key);
    }

    public void addTodoData(String title, String date) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.insertTodo(conn, title, date);
    }

    public void modifyTodoData(TodoData data) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateData(conn, data);
    }
}
