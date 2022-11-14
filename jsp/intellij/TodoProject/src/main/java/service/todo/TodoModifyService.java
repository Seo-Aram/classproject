package service.todo;

import lombok.Cleanup;
import module.todo.TodoData;
import util.ConnectionUtil;

import java.sql.Connection;

public class TodoModifyService implements ITodoService {
    public void modifyTodoData(TodoData data) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateData(conn, data);
    }
}
