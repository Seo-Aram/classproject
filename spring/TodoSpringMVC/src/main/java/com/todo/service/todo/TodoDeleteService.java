package com.todo.service.todo;

import com.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;

public class TodoDeleteService implements ITodoService {
    public void deleteTodoData(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.deleteData(conn, key);
    }
}
