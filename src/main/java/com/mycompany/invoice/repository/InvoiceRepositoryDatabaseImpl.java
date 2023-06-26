package com.mycompany.invoice.repository;

import com.mycompany.invoice.entity.Invoice;

public class InvoiceRepositoryDatabaseImpl implements IInvoiceRepository{

    public void create(Invoice invoice){
        System.out.println("Database : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
