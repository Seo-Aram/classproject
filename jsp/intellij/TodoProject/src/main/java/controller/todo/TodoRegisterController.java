package controller.todo;

import lombok.extern.log4j.Log4j2;
import service.todo.TodoInsertService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "TodoRegisterController", value = "/register")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String date = request.getParameter("date");

        try{
            TodoInsertService service = new TodoInsertService();
            service.insertTodo(title, date);
        } catch (Exception e) {
            log.error(e);
        }

        log.debug(title, date);

        response.sendRedirect("/list");
    }
}
