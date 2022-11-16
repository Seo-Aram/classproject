package controller.todo;

import lombok.extern.log4j.Log4j2;
import module.todo.TodoData;
import service.todo.TodoListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoListService service = new TodoListService();
        List<TodoData> list = null;
        try {
            list = service.selectAllTodo();
        } catch (Exception e) {
            log.error(e);
        }
        request.setAttribute("list", list);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/todo/list");
    }
}
