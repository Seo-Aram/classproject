package com.todo.service.todo;

import com.todo.module.todo.TodoData;
import com.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.util.List;

public class TodoListService implements ITodoService {
    public List<TodoData> selectAllTodo() throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectTodoList(conn);
    }
}
