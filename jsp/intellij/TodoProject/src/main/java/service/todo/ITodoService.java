package service.todo;

import dao.TodoListDao;

public interface ITodoService {
    TodoListDao dao = new TodoListDao();
}
