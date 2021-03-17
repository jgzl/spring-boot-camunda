package com.github.jgzl.framework.config;

import com.github.jgzl.framework.exception.CustomException;
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
        return new R().of(400,e.getMessage(),e);
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public R argument(HttpServletRequest request, HttpServletResponse response, IllegalArgumentException e){
        return new R().of(400,e.getMessage(),e);
    }
    @ExceptionHandler(value = CustomException.class)
    public R custom(HttpServletRequest request, HttpServletResponse response, CustomException e){
        return new R().of(e.getCode(),e.getMessage(),e);
    }
}
