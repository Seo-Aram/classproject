package com.todo.controller.sign;

import com.todo.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignOutController {
    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        request.getSession().removeAttribute("loginInfo");
        Cookie cookie = Util.findCookie(request.getCookies(), "loginInfo");
        if(cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "redirect:/sign/in";
    }
}
