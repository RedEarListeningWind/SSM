package com.crtf.ssm.core.controller;

import com.crtf.ssm.core.model.User;
import com.crtf.ssm.core.service.UserService;
import com.crtf.ssm.core.viewresolver.ExcelExportService;
import com.crtf.ssm.core.viewresolver.ExcelView;
import com.crtf.ssm.util.constant.ConstantQuantity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

/**
 * @author crtf
 * @version V1.0
 * @className MyViewController
 * @description 测试 自定义视图
 * @date 21.6.12 3:02
 */
@Controller
public class MyViewController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toMyView0")
    public String toMyView0(@SessionAttribute(ConstantQuantity.SESSION_USER) User user, ModelAndView modelAndView){
        modelAndView.addObject("user",user);
        return "crtf:crtf";
    }

    /**
     * 出口
     *

     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "export")
    public ModelAndView export(ModelAndView modelAndView){
        ExcelView excelView = new ExcelView("所有用户.xlsx",exportService());

        List<User> users = userService.selectAllUser();
        modelAndView.addObject("userList",users);

        modelAndView.setView(excelView);
        return modelAndView;
    }

    private ExcelExportService exportService(){
        return (model, workbook) -> {
            List<User> userList = (List<User>) model.get("userList");
            // 生成 sheet
            Sheet sheet = workbook.createSheet("所用用户");
            // 加载标题
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("编号");
            title.createCell(1).setCellValue("名称");
            title.createCell(2).setCellValue("密码");
            title.createCell(3).setCellValue("注册时间");
            // 便利角色列表，生成一行行的数据
            userList.stream().sorted(Comparator.comparingInt(User::getId)).forEach(user -> {
                Row row = sheet.createRow(user.getId());
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getPassword());
                row.createCell(3).setCellValue(user.getSignUp().toString());
            });
        };
    }
}

