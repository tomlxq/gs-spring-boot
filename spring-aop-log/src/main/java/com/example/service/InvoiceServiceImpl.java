package com.example.service;

import com.example.domain.Invoice;
import com.example.mappers.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tom on 2016/5/19.
 */
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;//Mapper接口

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceMapper.getInvoiceById(id);
    }
}
