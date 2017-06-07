package com.mika.credit.web.globaleagle.common.interceptor;

import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.model.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mike on 2017/2/15.
 */
public class CustomerLoginSimpleInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Customer c =  (Customer)request.getSession().getAttribute("customerInfo");
//        Manager m =  (Manager)request.getSession().getAttribute("managerInfo");
        if(c!=null){
            return true;
        }
        else{
            request.getRequestDispatcher("/simple/toLogin.do.do").forward(request, response);
            return false;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
