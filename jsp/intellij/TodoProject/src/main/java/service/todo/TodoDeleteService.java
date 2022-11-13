package service.todo;

import dao.TodoListDao;
import lombok.Cleanup;
import util.ConnectionUtil;

import java.sql.Connection;

public class TodoDeleteService {
    TodoListDao dao = new TodoListDao();

    public void deleteTodoData(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.deleteData(conn, key);
    }
}
