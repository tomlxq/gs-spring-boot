package com.example.view;

/**
 * Created by tom on 2016/5/15.
 */

import com.example.domain.Account;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

class XlsView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        Account account = (Account) model.get("account");

        Sheet sheet = workbook.createSheet("sheet1");
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        Row row = null;
        Cell cell = null;
        int rowCount = 0;
        int colCount = 0;

        // 创建头部
        row = sheet.createRow(rowCount++);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("NAME");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("MAIL");


        // 创建数据
        row = sheet.createRow(rowCount++);
        colCount = 0;
        row.createCell(colCount++).setCellValue(account.getName());
        row.createCell(colCount++).setCellValue(account.getEmail());
        for (int i = 0; i < 3; i++)
            sheet.autoSizeColumn(i, true);

    }

}

public class XlsViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        return new XlsView();
    }

}