package com.ztj.springbootdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    /*
    match different error type here
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception error) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", error);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /*
    handle restful api exceptions, return json message
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, JsonException error) {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setMessage(error.getMessage());
        info.setCode(ErrorInfo.ERROR);
        info.setData("Json Error Handler");
        info.setUrl(request.getRequestURL().toString());
        return info;
    }

}
