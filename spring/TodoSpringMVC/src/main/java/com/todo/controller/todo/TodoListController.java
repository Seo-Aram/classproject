package com.todo.controller.todo;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/list")
public class TodoListController {

    @GetMapping()
    public String getTodoListPage(){
        log.info("test");
        return "/todo/list";
    }
}
