package com.crtf.ssm.core.interceptor;

import com.crtf.ssm.core.model.User;
import com.crtf.ssm.util.constant.ConstantQuantity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author crtf
 * @version V1.0
 * @className CustomInterceptor
 * @description 自定义拦截器
 * @date 21.6.9 22:48
 */
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String requestURI = request.getRequestURI();
        // 获取Session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute(ConstantQuantity.SESSION_USER);
        // 判断Session中是否有用户数据
        boolean toSignIn = requestURI.contains("/signIn");
        boolean toNull = requestURI.replaceAll(request.getContextPath() + "/" + "|" + request.getContextPath() ,"").length() == 0;
        boolean isEmptyUser = sessionUser == null;

        if (toSignIn) {
            return true;
        }
        if (isEmptyUser) {
            // 转发到登录
            request.setAttribute("msg", "您还没有登录，请先登录！");
            request.getRequestDispatcher("/WEB-INF/view/sign_in.jsp").forward(request, response);
            return false;
        }
        if (toNull) {
            // 转发到主页
            request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}

