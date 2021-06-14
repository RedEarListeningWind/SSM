package com.crtf.ssm.core.viewresolver;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <pre>
 * {@link org.springframework.web.servlet.view.document.AbstractXlsView#createWorkbook HSSF}
 *      传统 XLS 格式的 Excel 文档视图的便捷超类,与 Apache POI 3.5 及更高版本兼容<br/>
 *
 * {@link AbstractXlsxStreamingView#createWorkbook SXSSF} <<推荐>>
 *      使用 POI 的流变体的 Office 2007 XLSX 格式的 Excel 文档视图的便捷超类,与 Apache POI 3.9 及更高版本兼容
 * </pre>
 *
 * @author crtf
 * @version V1.0
 * @className ExcelView
 * @description 测试 Excel 视图
 * @date 21.6.12 13:58
 */
public class ExcelView extends AbstractXlsxStreamingView {

    private String fileName = null;

    private ExcelExportService excelExportService = null;

    public ExcelView(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    public ExcelView(String fileName, ExcelExportService excelExportService) {
        this.fileName = fileName;
        this.excelExportService = excelExportService;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (excelExportService == null) {
            throw new RuntimeException("导出服务接口不能为null!!");
        }
        // 文件名不能为空，为空则使用请求路径中的字符串作为文件名
        if (!StringUtils.isEmpty(fileName)) {
            // 进行字符转换
            String reqCharset = request.getCharacterEncoding();
            reqCharset = reqCharset == null ? "UTF-8" : reqCharset;
            fileName = new String(fileName.getBytes(reqCharset), StandardCharsets.ISO_8859_1);
            // 设置下面文件名
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        }
        // 回调接口方法，使用自定义生成Excel文档
        excelExportService.makeWorkBook(model, workbook);
        // 设置文件大小
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        workbook.write(byteArrayOutputStream);
//        response.setHeader("Content-Length", "" + byteArrayOutputStream.size());
//        byteArrayOutputStream.close();
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExcelExportService getExcelExportService() {
        return excelExportService;
    }

    public void setExcelExportService(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }
}

