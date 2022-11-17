package com.example.mvc.springmvc.controller;

import com.example.mvc.springmvc.model.LoginRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/login")
public class LoginController {

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getLoginForm(Model model){
        model.addAttribute("msg", "아이디 및 패스워드 필수 입력");
        return "login/form";
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String login(String uid, String pw,
                        @RequestParam(value = "uid", required = false) String userId,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        @ModelAttribute("req") LoginRequest loginRequest,
                        @RequestParam Map paramMap){
        log.info("uid -> " + uid);
        log.info("pw -> " + pw);
        log.info("userId -> " + userId);

        String reqUid = request.getParameter("uid");
        log.info("reqUid -> " +reqUid);

        log.info(loginRequest);

        return "login/login";
    }

    @GetMapping("/info")
    public String info(){
        return "/login/info";
    }
}
