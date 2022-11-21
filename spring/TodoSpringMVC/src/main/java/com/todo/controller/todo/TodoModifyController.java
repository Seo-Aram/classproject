package com.todo.controller.todo;

import com.todo.module.todo.TodoData;
import com.todo.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {
    @Autowired
    private TodoService service;

    /*public TodoModifyController(TodoService service) {
        this.service = service;
    }*/

    @GetMapping
    public void getTodoModifyPage(Model model, @RequestParam(value="key", required = false) long key){
        TodoData data = null;

        try {
            data = service.selectTodoDataByKey(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("data", data);
    }

    @PostMapping
    public String postTodoModifyPage(@ModelAttribute("data") TodoData data){
        try {
            service.modifyTodoData(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/todo/list";
    }
}
