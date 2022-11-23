package com.todo.interceptor;

import com.todo.module.sign.Member;
import com.todo.service.sign.SignService;
import com.todo.util.ConfigUtil;
import com.todo.util.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@Log4j2
public class AutoLoginInterceptor implements HandlerInterceptor {
    @Autowired
    SignService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie cookie = Util.findCookie(request.getCookies(), "loginInfo");

        if(cookie != null && !cookie.getValue().isEmpty()) {
            log.info(cookie.getValue());

            Member member = service.signInByUUID(cookie.getValue());
            log.info(member);

            if(member != null) {
                if (!member.getProfileUrl().equals("")) {
                    File img = new File((String) ConfigUtil.getConfig("fileSaveDir") + member.getProfileUrl());
                    if (!img.exists()) {
                        member.setProfileUrl("");
                        service.updateProfileUrl("", member.getId());
                    }
                }

                UUID uuid = UUID.randomUUID();
                member.setUuid(uuid.toString());
                service.updateUUID(member.getUuid(), member.getId());
                request.getSession(true).setAttribute("loginInfo", member.toLoginInfo());

                cookie.setMaxAge(60 * 60 * 24);
                cookie.setValue(uuid.toString());
                response.addCookie(cookie);
                log.info("auto login Success...");
            } else {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
