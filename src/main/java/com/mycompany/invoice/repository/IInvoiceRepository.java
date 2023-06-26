package com.mycompany.invoice.repository;

import com.mycompany.invoice.entity.Invoice;

public interface IInvoiceRepository {
    void create(Invoice invoice);
}
