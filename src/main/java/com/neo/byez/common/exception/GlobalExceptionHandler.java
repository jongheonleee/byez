package com.neo.byez.common.exception;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({PersistenceException.class, CannotGetJdbcConnectionException.class, CommunicationsException.class})
    public ModelAndView handleCommunicationsException(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", "db접속 오류입니다.");
        mav.setViewName("errorPage");
        return mav;
    }

    @ExceptionHandler(CouponException.class)
    public ModelAndView handleException(CouponException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", e.getMessage());
        mav.setViewName("errorPage");
        return mav;
    }
}