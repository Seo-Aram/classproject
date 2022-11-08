package com.firstcoding.firstapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SignupServlet", urlPatterns ="/signup")
public class SignupServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SignUp</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Login Data</h1>");
        out.println("<hr/>");
        out.println("id: " + userId + "<br/>");
        out.println("pw: " + userPw + "<br/>");
        out.println("name: " + userName + "<br/>");
        out.println("</body>");
        out.println("</html>");
    }
}
