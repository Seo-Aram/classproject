package com.todo.controller.sign;

import com.todo.module.sign.MemberRegRequest;
import com.todo.service.sign.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ){
        if(regRequest.getUserId() == null || regRequest.getPassword() == null
                || regRequest.getUserId().isEmpty() || regRequest.getPassword().isEmpty()) {
            return "redirect:/sign/up?result=n";
        }

        try {
            service.signUp(regRequest, request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // redirectAttributes.addAttribute("","");
        redirectAttributes.addFlashAttribute("result","ups"); // 1회성 소멸

        return "redirect:/sign/in";
    }

    @GetMapping("test")
    @ResponseBody // return 값만 반환함(페이지를 반환하지 않고 data 반환)
    @ExceptionHandler() // 예외 발생 페이지
    public String test(){
        return "test";
    }
}
