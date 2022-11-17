package com.todo.service.todo;

import com.todo.module.todo.TodoData;
import com.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;

public class TodoDataService implements ITodoService{

    public TodoData selectTodoData(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectData(conn, key);
    }
}
