package com.crtf.ssm.core.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@link ControllerAdvice} 主要作用类，用以标识全局性的控制器的拦截器，它将应用于对应的控制器<br/>
 * {@link InitBinder } 是一个允许构建POJO参数的方法，允许在构造控制器参数的时候，加入一定的自定义控制。<br/>
 * {@link ExceptionHandler } 通过它可以注册一个控制器异常，使用当控制器发生注册异常时，就会跳转到该方法上。<br/>
 * {@link ModelAttribute } 是一种针对于数据模型的注解，它先于控制器方法运行，当标注方法返回对象时，它会保存到数据模型中。<br/>
 *
 * @author crtf
 * @version V1.0
 * @className CommonControllerAdvice
 * @description 为控制器添加通知
 * @date 21.6.11 13:01
 */
// 标识控制器通知，并且指定对应的包
@ControllerAdvice(basePackages = {"com.crtf.ssm.controller0"})
public class CommonControllerAdvice {
    /**
     * 定义HTTP对应参数处理规则
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        // 针对日期类型的格式化，其中CustomDataEditor是客户自定义编辑器
        // 它的boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    /**
     * 处理数据模型，如果返回对象，则该对象会保存在
     */
    @ModelAttribute
    public void populateModel(Model model){
        model.addAttribute("projectName","chapter16");
    }

    /**
     * 异常处理，使得被拦截的控制器方法发生异常时，都能用相同的视图响应
     */
    @ExceptionHandler(value = Exception.class)
    public String exception(){
        return "exception";
    }

}

