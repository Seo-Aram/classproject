package com.todo.controller.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/member/info")
public class MemberInfoController {
    @GetMapping
    public String getInfo(HttpServletRequest request){
        log.info(request.getSession().getAttribute("loginInfo"));
        return "/member/info";
    }
}
