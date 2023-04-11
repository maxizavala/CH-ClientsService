package com.deg.productservice.service;

import com.deg.productservice.model.Invoice;
import com.deg.productservice.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    // Obtener todas las facturas
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Crear factura
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

}
