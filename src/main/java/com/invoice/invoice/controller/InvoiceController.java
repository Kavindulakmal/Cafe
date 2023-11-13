package com.invoice.invoice.controller;

import com.invoice.invoice.model.Invoice;
import com.invoice.invoice.model.Payment;
import com.invoice.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice){
        Invoice savedInvoice = invoiceService.addInvoice(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }

    @PostMapping("/{invoiceId}/balance")
    public ResponseEntity<Void> addPayment(@PathVariable Long InvoiceId, @RequestBody Payment payment){
        invoiceService.addPayment(InvoiceId, payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{invoiceId}/pdf")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long invoiceId){
        BigDecimal balance = invoiceService.calculateBalance(invoiceId);
        return  new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @GetMapping("/{invoiceId}/pdf")
    public ResponseEntity<byte[]> generatePdf(@PathVariable Long invoiceId){
        byte[] pdfBytes = invoiceService.generatePdf(invoiceId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline","invoice.pdf");
        return new ResponseEntity<>(pdfBytes,headers,HttpStatus.OK);
    }




}