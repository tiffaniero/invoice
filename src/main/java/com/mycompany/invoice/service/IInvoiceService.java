package com.mycompany.invoice.service;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;

public interface IInvoiceService {
    void createInvoice(Invoice invoice);

    void setInvoiceRepository(IInvoiceRepository invoiceRepository);
}
