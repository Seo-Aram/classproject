package com.todo.controller.todo;

import com.todo.module.sign.LoginInfo;
import com.todo.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/todo/register")
public class TodoRegistController {
    private final TodoService service;

    public TodoRegistController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public void getTodoRegisterPage(){
    }

    @PostMapping
    public String postTodoRegisterPage(@RequestParam(value="title", required = false) String title,
                                       @RequestParam(value="date", required = false) String date,
                                       HttpServletRequest request){

        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("loginInfo");

        try {
            service.addTodoData(title, date, loginInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/todo/list";
    }
}
