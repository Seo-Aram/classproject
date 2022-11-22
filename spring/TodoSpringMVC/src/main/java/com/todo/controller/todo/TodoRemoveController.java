package com.todo.controller.todo;

import com.todo.module.sign.LoginInfo;
import com.todo.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/todo/remove")
public class TodoRemoveController {

    private final TodoService service;

    public TodoRemoveController(TodoService service) {
        this.service = service;
    }

    @GetMapping()
    public String getTodoRemovePage(@RequestParam(name="key", required = true) long key,
                                    HttpServletRequest request) {

        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("loginInfo");

        try {
            service.removeTodoDataByKey(key, loginInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/todo/list";
    }
}
