package com.todo.controller.todo;

import com.todo.module.sign.LoginInfo;
import com.todo.module.todo.TodoData;
import com.todo.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public void getTodoModifyPage(
            Model model,
            @RequestParam(value="key", required = false) long key,
            HttpServletRequest request){

        TodoData data = null;
        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("loginInfo");

        try {
            data = service.selectTodoDataByKey(key, loginInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("data", data);
    }

    @PostMapping
    public String postTodoModifyPage(
            @ModelAttribute("data") TodoData data,
            HttpServletRequest request){

        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("loginInfo");
        try {
            service.modifyTodoData(data, loginInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/todo/list";
    }
}
