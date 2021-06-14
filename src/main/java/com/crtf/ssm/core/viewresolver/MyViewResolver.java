package com.crtf.ssm.core.viewresolver;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author crtf
 * @version V1.0
 * @className MyViewResolver
 * @description 测试 视图解析器
 * @date 21.6.12 2:29
 */
public class MyViewResolver implements ViewResolver, Ordered {

    private int order = 0;


    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        View result = null;
        if (viewName.startsWith("crtf")){

            result = new MyView();
        }
        return result;
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

