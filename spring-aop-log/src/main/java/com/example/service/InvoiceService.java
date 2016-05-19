package com.example.service;

import com.example.domain.Invoice;

/**
 * Created by tom on 2016/5/19.
 */
public interface InvoiceService {
    Invoice getInvoiceById(Long id);
}
