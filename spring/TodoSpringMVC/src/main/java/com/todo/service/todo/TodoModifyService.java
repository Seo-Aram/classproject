package com.todo.service.todo;

import com.todo.module.todo.TodoData;
import com.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;

public class TodoModifyService implements ITodoService {
    public void modifyTodoData(TodoData data) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateData(conn, data);
    }
}
