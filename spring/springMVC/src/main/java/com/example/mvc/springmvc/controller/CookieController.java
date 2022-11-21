package com.example.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("/view/{idx}")
    public String viewCookie(
            @CookieValue(name = "userName") String userName,
            @RequestHeader(value = "referer", required = false) String referer,
            @PathVariable int idx
    ){
        log.info(userName);

        log.info(referer);

        log.info(idx);

        return "cookie/view";
    }

    @GetMapping("/make")
    public String makeCookie(
            HttpServletResponse response
    ) {
        Cookie cookie = new Cookie("userName", "son");
        cookie.setPath("/");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        return "cookie/make";
    }
}
