package com.todo.util;

import javax.servlet.http.Cookie;

public class Util {

    public static Cookie findCookie(Cookie[] cookies, String key) {
        if(cookies == null || cookies.length == 0) return null;

        Cookie cookie = null;

        for(Cookie c : cookies) {
            if(c.getName().equals(key)) {
                cookie = c;
                break;
            }
        }

        return cookie;
    }
}
