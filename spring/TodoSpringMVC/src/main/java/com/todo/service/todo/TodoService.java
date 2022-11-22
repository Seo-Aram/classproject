package com.todo.service.todo;

import com.todo.dao.ITodoDao;
import com.todo.module.sign.LoginInfo;
import com.todo.module.todo.TodoData;
import com.todo.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;


@Service
@Log4j2
public class TodoService {

    private final ITodoDao dao;

    public TodoService(ITodoDao dao) {
        this.dao = dao;
    }

    public List<TodoData> selectAllTodo(LoginInfo loginInfo) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectTodoList(conn, loginInfo);
    }

    public TodoData selectTodoDataByKey(long key, LoginInfo loginInfo) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectData(conn, key, loginInfo);
    }

    public void removeTodoDataByKey(long key, LoginInfo loginInfo) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.deleteData(conn, key, loginInfo);
    }

    public void addTodoData(String title, String date, LoginInfo loginInfo) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.insertTodo(conn, title, date, loginInfo);
    }

    public void modifyTodoData(TodoData data, LoginInfo loginInfo) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateData(conn, data, loginInfo);
    }
}
