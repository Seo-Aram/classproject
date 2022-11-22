package com.todo.controller.sign;

import com.todo.module.sign.Member;
import com.todo.service.sign.SignService;
import com.todo.util.ConfigUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Log4j2
@Controller
@RequestMapping("/sign/in")
public class SignInController {
    private final SignService service;

    public SignInController(SignService service) {
        this.service = service;
    }

    @GetMapping
    public String getLogin(){
        return "/sign/signInForm";
    }


    @PostMapping
    public String postLogin(
            @RequestParam("user_id") String userID,
            @RequestParam("password") String password,
            HttpServletRequest request
    ){
        try {
            Member member = service.signInByIdPw(userID, password);

            log.info(member);

            if(member != null) {

                if(!member.getProfileUrl().equals("")) {
                    File img = new File((String)ConfigUtil.getConfig("fileSaveDir")+member.getProfileUrl());
                    if(!img.exists()) {
                        member.setProfileUrl("");
                        service.updateProfileUrl("", userID);
                    }
                }
                request.getSession(true).setAttribute("loginInfo", member.toLoginInfo());

                return "redirect:/todo/list";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/sign/in?result=l";
    }
}
