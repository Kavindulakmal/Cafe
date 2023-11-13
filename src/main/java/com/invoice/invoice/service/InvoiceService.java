package com.invoice.invoice.service;

import com.invoice.invoice.model.Invoice;
import com.invoice.invoice.model.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface InvoiceService {

    Invoice addInvoice(Invoice invoice);
    void addPayment(Long invoiceId, Payment payment);
    BigDecimal calculateBalance(Long invoiceId);
    byte[] generatePdf(Long invoiceId);
}
