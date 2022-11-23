package com.todo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice{

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public String exceptNumber(NoHandlerFoundException e) {
        return "NoHandlerFoundException";
    }
}
