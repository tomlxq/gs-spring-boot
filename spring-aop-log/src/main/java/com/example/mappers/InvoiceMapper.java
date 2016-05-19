package com.example.mappers;

import com.example.domain.Invoice;

/**
 * Created by tom on 2016/5/19.
 */
public interface InvoiceMapper {
    Invoice getInvoiceById(Long id);
}
