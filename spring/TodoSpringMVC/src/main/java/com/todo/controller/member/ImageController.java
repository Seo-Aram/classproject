package com.todo.controller.member;

import com.todo.module.sign.LoginInfo;
import com.todo.util.ConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/image")
public class ImageController {
    public String getImageURL(
            HttpServletRequest request
    ) {
        String result = "";

        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("loginInfo") != null) {
            LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");

            if(loginInfo.getProfileUrl() != null && !loginInfo.getProfileUrl().isEmpty()) {
                result = (String)ConfigUtil.getConfig("resourcesURI") + loginInfo.getProfileUrl();
            }
        }

        return result;
    }
}
