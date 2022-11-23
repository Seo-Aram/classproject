package com.todo.controller.sign;

import com.todo.util.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
public class SignOutController {
    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        HttpSession session = request.getSession(false);
        if(session != null ) {
            request.getSession().removeAttribute("loginInfo");
        }
        Cookie cookie = Util.findCookie(request.getCookies(), "loginInfo");
        if(cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            log.info("Logout");
        }

        return "redirect:/sign/in";
    }
}
