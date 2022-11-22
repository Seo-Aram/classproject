package com.todo.controller.sign;

import com.todo.module.sign.MemberRegRequest;
import com.todo.service.sign.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sign/up")
public class SignUpController {
    private final SignService service;

    public SignUpController(SignService service) {
        this.service = service;
    }

    @GetMapping
    public String getRegForm(){
        return "/sign/signUpForm";
    }

    @PostMapping
    public String postReg(
            MemberRegRequest regRequest,
            HttpServletRequest request
    ){

        try {
            service.signUp(regRequest, request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/sign/in?result=ups";
    }
}
