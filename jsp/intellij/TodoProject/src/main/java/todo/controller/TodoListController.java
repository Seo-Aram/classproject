package todo.controller;

import todo.module.TodoDataList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoListController", value = "/list")
public class TodoListController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 데이터 초기화 하자
        TodoDataList.getInstance().initializeData();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", TodoDataList.getInstance().getList());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/list");
    }
}
