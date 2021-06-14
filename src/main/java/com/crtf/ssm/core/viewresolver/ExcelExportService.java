package com.crtf.ssm.core.viewresolver;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

/**
 * Excel导出服务
 * @author crtf
 * @version 1.0
 * @createDate 2021年6月12日 星期六 14:09
 */
public interface ExcelExportService {

    /**
     * 生成exel文件规则
     * @param model 数据模型
     * @param workbook 工作簿
     */
    void makeWorkBook(Map<String,Object> model, Workbook workbook);

}
