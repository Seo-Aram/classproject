package com.todo.controller.todo;

import com.todo.module.todo.TodoData;
import com.todo.service.todo.TodoListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/todo/list")
public class TodoListController {

    @GetMapping()
    public String getTodoListPage(Model model){
        log.info("test");

        TodoListService service = new TodoListService();
        List<TodoData> list = null;
        try {
            list = service.selectAllTodo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("list", list);

        return "/todo/list";
    }
}
