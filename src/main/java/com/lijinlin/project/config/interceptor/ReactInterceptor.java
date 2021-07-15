package com.lijinlin.project.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ReactInterceptor implements HandlerInterceptor {
    private static ThreadLocal<HttpServletRequest> localRequest = new ThreadLocal();


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest request1 = (HttpServletRequest) localRequest.get();
        HttpSession session = request.getSession();
        System.out.print(session);
        return true;
    }
}
