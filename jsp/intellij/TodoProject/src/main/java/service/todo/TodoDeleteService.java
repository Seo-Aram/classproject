package service.todo;

import lombok.Cleanup;
import util.ConnectionUtil;

import java.sql.Connection;

public class TodoDeleteService implements ITodoService {
    public void deleteTodoData(long key) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.deleteData(conn, key);
    }
}
