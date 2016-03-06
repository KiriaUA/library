package com.starikov.libraryonline.interceptors;

import com.starikov.libraryonline.utils.IUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilsInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private IUtils utils;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.getModelMap().addAttribute("letters", utils.getLetters());
        super.postHandle(request, response, handler, modelAndView);
    }
}
