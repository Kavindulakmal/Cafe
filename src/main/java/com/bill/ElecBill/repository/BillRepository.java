package com.bill.ElecBill.repository;

import com.bill.ElecBill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill , Long> {
}
