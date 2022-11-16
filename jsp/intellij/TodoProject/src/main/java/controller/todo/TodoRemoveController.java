package controller.todo;

import service.todo.TodoDeleteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRemoveController", value = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sKey = request.getParameter("key");
        if(sKey != null ){
            long key = Long.parseLong(request.getParameter("key"));

            try {
                TodoDeleteService service = new TodoDeleteService();
                service.deleteTodoData(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/todo/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long key = Long.parseLong(request.getParameter("key"));

        try {
            TodoDeleteService service = new TodoDeleteService();
            service.deleteTodoData(key);
        } catch(Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/todo/list");
    }
}
