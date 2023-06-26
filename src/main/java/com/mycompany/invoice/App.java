package com.mycompany.invoice;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.controller.InvoiceControllerDouchetteImpl;
import com.mycompany.invoice.controller.InvoiceControllerKeyboardImpl;
import com.mycompany.invoice.controller.InvoiceControllerWebImpl;
import com.mycompany.invoice.repository.IInvoiceRepository;
import com.mycompany.invoice.repository.InvoiceRepositoryMemoryImpl;
import com.mycompany.invoice.repository.InvoiceRepositoryDatabaseImpl;
import com.mycompany.invoice.service.IInvoiceService;
import com.mycompany.invoice.service.InvoiceServiceNumberImpl;
import com.mycompany.invoice.service.InvoiceServicePrefixImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Quelle classe de controller ?");
        Scanner sc = new Scanner(System.in);
        String controllerType = sc.nextLine();
        System.out.println("Quelle classe de service ?");
        String serviceType = sc.nextLine();
        System.out.println("Quelle classe de repository ?");
        String repositoryType = sc.nextLine();

        //Inversion de controle
        IInvoiceController invoiceController = null;

        IInvoiceService invoiceService = null;

        IInvoiceRepository invoiceRepository = null;

        try {
            invoiceController = (IInvoiceController) Class.forName(controllerType).getDeclaredConstructor().newInstance();
            invoiceService = (IInvoiceService) Class.forName(serviceType).getDeclaredConstructor().newInstance();
            invoiceRepository = (IInvoiceRepository) Class.forName(repositoryType).getDeclaredConstructor().newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }

        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);

        invoiceController.createInvoice();


       /* int configuration = sc.nextInt();
        if (configuration == 1){
            InvoiceControllerKeyboardImpl invoiceController = new InvoiceControllerKeyboardImpl();
            InvoiceServiceNumberImpl invoiceService = new InvoiceServiceNumberImpl();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryMemoryImpl invoiceRepository = new InvoiceRepositoryMemoryImpl();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        } else if (configuration == 2){
            InvoiceControllerWebImpl invoiceController = new InvoiceControllerWebImpl();
            InvoiceServicePrefixImpl invoiceService = new InvoiceServicePrefixImpl();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryDatabaseImpl invoiceRepository = new InvoiceRepositoryDatabaseImpl();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        } else if (configuration == 3){
            InvoiceControllerWebImpl invoiceController = new InvoiceControllerWebImpl();
            InvoiceServiceNumberImpl invoiceService = new InvoiceServiceNumberImpl();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryDatabaseImpl invoiceRepository = new InvoiceRepositoryDatabaseImpl();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        } else if (configuration == 4){
            InvoiceControllerDouchetteImpl invoiceController = new InvoiceControllerDouchetteImpl();
            InvoiceServiceNumberImpl invoiceService = new InvoiceServiceNumberImpl();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryDatabaseImpl invoiceRepository = new InvoiceRepositoryDatabaseImpl();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }*/
    }
}
