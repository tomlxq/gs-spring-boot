package com.example.view;

import com.example.domain.Account;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Locale;
import java.util.Map;

/**
 * Created by tom on 2016/5/15.
 */
class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        Account account = (Account) model.get("account");

        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("NAME");
        table.addCell("MAIL");

        table.addCell(account.getName());
        table.addCell(account.getEmail());

        document.add(table);
    }

}

public class PdfViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        return new PdfView();
    }


}