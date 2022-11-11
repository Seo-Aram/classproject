package todo.controller;

import todo.module.TodoData;
import todo.module.TodoDataList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoModifyController", value = "/modify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String key = request.getParameter("key");
        TodoData data = TodoDataList.getInstance().getTodoData(key);

        request.setAttribute("data", data);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String key = request.getParameter("key");
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        boolean isCheck = request.getParameter("isCheck") != null ? true : false;

        TodoDataList.getInstance().updateTodoData(key, title, date, isCheck);

        RequestDispatcher rd = request.getRequestDispatcher("/list");
        rd.forward(request, response);
    }
}
