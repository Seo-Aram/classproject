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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

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
            @RequestParam(name="remember", required = false) boolean isRemember,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        try {
            Member member = service.signInByIdPw(userID, password);

            log.info(isRemember);

            if(member != null) {

                if(!member.getProfileUrl().equals("")) {
                    File img = new File((String)ConfigUtil.getConfig("fileSaveDir")+member.getProfileUrl());
                    if(!img.exists()) {
                        member.setProfileUrl("");
                        service.updateProfileUrl("", userID);
                    }
                }
                UUID uuid = UUID.randomUUID();
                member.setUuid(uuid.toString());
                service.updateUUID(member.getUuid(), member.getId());

                request.getSession(true).setAttribute("loginInfo", member.toLoginInfo());

                if(isRemember) {
                    Cookie cookie = new Cookie("loginInfo", uuid.toString());
                    cookie.setPath("/");
                    cookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookie);
                }

                return "redirect:/todo/list";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/sign/in?result=l";
    }
}
