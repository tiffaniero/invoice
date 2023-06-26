package com.mycompany.invoice.service;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;

public class InvoiceServicePrefixImpl implements IInvoiceService{

    private static long lastNumber=112L;

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private IInvoiceRepository invoiceRepository;

    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf("INV_" + (++lastNumber)));
        invoiceRepository.create(invoice);
    }
}
