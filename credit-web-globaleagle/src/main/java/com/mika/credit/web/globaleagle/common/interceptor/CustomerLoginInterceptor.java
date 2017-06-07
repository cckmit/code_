package com.mika.credit.web.globaleagle.common.interceptor;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.model.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gavin on 2015/7/19.
 */
public class CustomerLoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Customer c =  (Customer)request.getSession().getAttribute("customerInfo");
        Manager m =  (Manager)request.getSession().getAttribute("managerInfo");

        if(c!=null||m!=null){
            return true;
        }
        else{
            String  url = request.getHeader("referer");
            request.getSession().setAttribute("url",url);
            request.getRequestDispatcher("/toLogin.do").forward(request, response);
            return false;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
