package todo.controller;

import todo.module.TodoData;
import todo.module.TodoDataList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoReadController", value = "/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String key = request.getParameter("key");
        TodoData data = TodoDataList.getInstance().getTodoData(key);

        request.setAttribute("data", data);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/list");
    }
}
