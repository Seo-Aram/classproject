package com.todo.controller.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignOutController {
    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request
    ) {
        request.getSession().removeAttribute("loginInfo");
        return "redirect:/sign/in";
    }
}
