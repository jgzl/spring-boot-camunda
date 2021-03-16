package com.github.jgzl.framework.config;

import com.github.jgzl.framework.vo.R;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R validator(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException e){
        return new R().failed(e);
    }
}
