package filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(filterName = "SignInFilter", urlPatterns = {"/todo/*"})
public class SignInFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();

        log.info("signin check");

        if(session.getAttribute("loginInfo") == null) {
            log.info("session is null");
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("/sign/signIn");
            return;
        }

        chain.doFilter(request, response);
    }

}
