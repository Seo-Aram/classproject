package com.todo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionAdvice{

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String exceptNumber(NumberFormatException e) {
        return "NumberFormatException";
    }
}
