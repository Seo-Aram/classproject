package service.todo;

import controller.dao.TodoListDao;
import lombok.Cleanup;
import module.todo.TodoData;
import util.ConnectionUtil;

import java.sql.Connection;

public class TodoDataService {
    TodoListDao dao = new TodoListDao();

    public TodoData selectTodoData(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectData(conn, key);
    }
}
