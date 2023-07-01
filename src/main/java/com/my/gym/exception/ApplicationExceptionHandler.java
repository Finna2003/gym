package com.my.gym.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler({NullEntityReferenceException.class, EntityNotFoundException.class})
    public ModelAndView handleCustomExceptions(RuntimeException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handle404Exception() {
        return new ModelAndView("404");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handle500Exception() {
        return new ModelAndView("500");
    }
}
