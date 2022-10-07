package com.lipcoder.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

// 스프링 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

    // 해당 메서드가 Exception.class 예외 클래스 유형을 처리 하겠다.
    @ExceptionHandler(Exception.class)
    public String except(Exception ex, Model model) {

        log.error("Exception ......." + ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);
        return "error_page";
    }

    // 404 에러에 대한 예외를 받아 처리
    // web.xml
    // > dispatcher configuration
    //      >  throwExceptionIfHandlerFound
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex) {

        return "custom404";
    }
}

