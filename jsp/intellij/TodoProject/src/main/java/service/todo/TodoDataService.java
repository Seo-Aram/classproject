package service.todo;

import lombok.Cleanup;
import module.todo.TodoData;
import util.ConnectionUtil;

import java.sql.Connection;

public class TodoDataService implements ITodoService{

    public TodoData selectTodoData(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectData(conn, key);
    }
}
