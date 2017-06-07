package com.mika.credit.web.globalsearch.common.interceptor;

import com.mika.credit.facade.globalsearch.core.model.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gavin on 2015/7/19.
 */
public class ManagerLoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Manager m =  (Manager)request.getSession().getAttribute("managerInfo");
        if(m!=null){
            return true;
        }
        else{
            request.getRequestDispatcher("/toManagerLogin.do").forward(request, response);
            return false;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
