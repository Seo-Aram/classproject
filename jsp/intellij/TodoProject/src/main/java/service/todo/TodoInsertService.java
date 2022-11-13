package service.todo;

import dao.TodoListDao;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import util.ConnectionUtil;

import java.sql.Connection;

@Log4j2
public class TodoInsertService {
    private TodoListDao dao = new TodoListDao();

    public void insertTodo(String title, String date) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();


        log.debug(title, date);

        dao.insertTodo(conn, title, date);
    }
}
