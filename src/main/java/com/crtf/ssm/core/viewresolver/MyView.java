package com.crtf.ssm.core.viewresolver;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author crtf
 * @version V1.0
 * @className MyView
 * @description 测试 视图
 * @date 21.6.12 2:33
 */
public class MyView implements View {
    /**
     * 如果预先确定，则返回视图的内容类型。
     * 可用于预先检查视图的内容类型，即在实际渲染尝试之前
     *
     * @return
     */
    @Override
    public String getContentType() {
        return View.super.getContentType();
    }

    /**
     * 渲染给定模型的视图。
     * 第一步是准备请求：在 JSP 情况下，这意味着将模型对象设置为请求属性。 第二步将是视图的实际呈现，例如通过 RequestDispatcher 包含 JSP。
     *
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<h1>crtf 视图解析器</h1>");
        Object user = ((ModelAndView) model.get("modelAndView")).getModel().get("user");
        if (user != null) {
            response.getWriter().write("<h3>" + user + "</h3>");
        }
    }


}

