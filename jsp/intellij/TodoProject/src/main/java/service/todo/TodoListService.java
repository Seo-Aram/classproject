package service.todo;

import lombok.Cleanup;
import module.todo.TodoData;
import util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class TodoListService implements ITodoService {
    public List<TodoData> selectAllTodo() throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectTodoList(conn);
    }
}
