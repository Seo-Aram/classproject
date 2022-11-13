package service.todo;

import controller.dao.TodoListDao;
import lombok.Cleanup;
import module.todo.TodoData;
import util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class TodoListService {
    private TodoListDao dao = new TodoListDao();

    public List<TodoData> selectAllTodo() throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectTodoList(conn);
    }
}
