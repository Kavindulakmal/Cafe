package com.invoice.invoice.repository;

import com.invoice.invoice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepostory extends JpaRepository<Payment,Long> {
}
