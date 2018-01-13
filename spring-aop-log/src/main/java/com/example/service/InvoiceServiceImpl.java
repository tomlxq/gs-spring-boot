package com.example.service;

import com.example.domain.Invoice;
import com.example.mappers.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tom on 2016/5/19.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;//Mapper接口

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceMapper.getInvoiceById(id);
    }

    @Override
    public void insertInvoice(Invoice invoice) {
        invoiceMapper.insertInvoice(invoice);
    }
}
