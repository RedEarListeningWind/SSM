package com.crtf.ssm.util.language;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author crtf
 * @version V1.0
 * @className CustomLocaleResolver
 * @description 自定义区域信息解析器
 * @date 21.6.11 20:46
 */
public class CustomLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale result = request.getLocale();
        String locale = request.getParameter("locale");
        HttpSession session = request.getSession();
        String key = "locale";
        if (locale != null) {
            session.setAttribute(key, locale);
        } else {
            locale = (String) session.getAttribute(key);
        }
        if (locale != null) {
            String[] localeSplit = locale.split("_");
            switch (localeSplit.length) {
                case 0:
                    break;
                case 1:
                    result = new Locale(localeSplit[0]);
                    break;
                case 2:
                    result = new Locale(localeSplit[0], localeSplit[1]);
                    break;
                case 3:
                    result = new Locale(localeSplit[0], localeSplit[1], localeSplit[2]);
                    break;
                default:
            }
        }
        return result;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException("不支持区域信息设置");
    }

}

