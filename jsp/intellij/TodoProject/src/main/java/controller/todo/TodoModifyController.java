package controller.todo;

import lombok.extern.log4j.Log4j2;
import module.todo.TodoData;
import service.todo.TodoDataService;
import service.todo.TodoModifyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "TodoModifyController", value = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long key = Long.parseLong(request.getParameter("key"));
        TodoData data = null;

        try {
            TodoDataService service = new TodoDataService();
            data = service.selectTodoData(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            log.error(e.getMessage());
            log.error(e.getStackTrace());
        }

        request.setAttribute("data", data);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long key = Long.parseLong(request.getParameter("key"));
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        boolean isCheck = request.getParameter("isCheck") != null ? true : false;

        try {
            TodoModifyService service = new TodoModifyService();
            service.modifyTodoData(new TodoData(key, title, date, isCheck));
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/todo/list");
        rd.forward(request, response);
    }
}
