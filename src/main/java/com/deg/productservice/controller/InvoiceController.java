package com.deg.productservice.controller;

import com.deg.productservice.exception.ClientAlreadyExistsException;
import com.deg.productservice.model.Invoice;
import com.deg.productservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(path = "/")
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) throws ClientAlreadyExistsException {
        return new ResponseEntity<>(this.invoiceService.create(invoice), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Invoice>> findAll() {
        return new ResponseEntity<>(this.invoiceService.findAll(), HttpStatus.OK);
    }
}
