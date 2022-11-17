package com.todo.controller.todo;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/register")
public class TodoRegistController {
    @GetMapping
    public void getTodoRegisterPage(){
    }

    @PostMapping
    public String postTodoRegisterPage(){
        return "/todo/list";
    }
}
