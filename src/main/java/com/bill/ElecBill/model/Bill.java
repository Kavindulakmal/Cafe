package com.bill.ElecBill.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ebill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CusID")
    private Long customerId;
    @Column(name = "Units")
    private  int units;
    @Column(name = "Amount")
    private double amount;
    @Column(name = "Discount")
    private double discount;
    @Column(name = "FBill")
    private double finalBill;
}
