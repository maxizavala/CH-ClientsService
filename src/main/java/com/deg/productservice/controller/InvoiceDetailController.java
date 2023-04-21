package com.deg.productservice.controller;

import com.deg.productservice.exception.ClientAlreadyExistsException;
import com.deg.productservice.model.InvoiceDetail;
import com.deg.productservice.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @PostMapping(path = "/")
    public ResponseEntity<InvoiceDetail> create(@RequestBody InvoiceDetail invoiceDetail) throws ClientAlreadyExistsException {
        return new ResponseEntity<>(this.invoiceDetailService.create(invoiceDetail), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<InvoiceDetail>> findById(Long id) {
        return new ResponseEntity<>(this.invoiceDetailService.getInvoiceDetailsById(id), HttpStatus.OK);
    }
}
