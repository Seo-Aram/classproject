package com.todo.service.todo;

import com.todo.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;

@Log4j2
public class TodoInsertService implements ITodoService {
    public void insertTodo(String title, String date) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();


        log.debug(title, date);

        dao.insertTodo(conn, title, date);
    }
}
