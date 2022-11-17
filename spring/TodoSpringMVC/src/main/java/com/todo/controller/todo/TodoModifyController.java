package com.todo.controller.todo;

import com.todo.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {
    private final TodoService service;

    public TodoModifyController(TodoService service) {
        this.service = service;
    }

    @GetMapping()
    public void getTodoModifyPage(){
    }

    @PostMapping
    public String postTodoModifyPage(){
        return "/todo/list";
    }
}
