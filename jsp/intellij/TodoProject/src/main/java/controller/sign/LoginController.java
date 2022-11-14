package controller.sign;

import service.sign.SignInService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession(false) != null && request.getSession().getAttribute("id") != null) {
            response.sendRedirect("/todo/list");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sign/login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        boolean isSuccess = false;

        try {
            SignInService service = new SignInService();
            isSuccess = service.signInService(id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(isSuccess) {
            request.getSession(true);
            request.getSession().setAttribute("id", id);
            response.sendRedirect("/todo/list");
        } else {
            response.sendRedirect("/login");
        }
    }
}
