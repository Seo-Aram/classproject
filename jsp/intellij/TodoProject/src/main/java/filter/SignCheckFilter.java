package filter;

import module.Member;
import service.sign.SignInService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SignCheckFilter", urlPatterns = "/sign/*")
public class SignCheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") == null) {
            Cookie cookie = findCookie(req.getCookies(), "");

            if(cookie != null) {
                Member member = null;
                try {
                    member = new SignInService().signInByUUID(cookie.getValue());

                    if(member != null) {
                        session.setAttribute("loginInfo", member);

                        //cookie에 uuid갱신하여 추가해주기
                    }
                } catch (Exception e) {
                    //throw new RuntimeException(e);
                    e.printStackTrace();
                }
            }
        }

        chain.doFilter(request, response);
    }

    private Cookie findCookie(Cookie[] cookies, String key) {
        if(cookies == null || cookies.length == 0) return null;

        Cookie cookie = null;

        for(Cookie c : cookies) {
            if(c.getName().equals(key)) {
                cookie = c;
                break;
            }
        }

        return cookie;
    }
}
