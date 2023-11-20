package com.bill.ElecBill.service;

import com.bill.ElecBill.model.Bill;
import com.bill.ElecBill.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    public static Bill calculateBill (Customer customer){
        Bill bill = new Bill();
        bill.setCustomerId(customer.getId());
        bill.setUnits(customer.getUnits());

        //define unit price and thresholds
        double unitPrice1 = 8;
        double unitPrice2 = 12;
        double unitPrice3 = 16;
        double unitPrice4 = 20;

        int threshold1 = 30;
        int threshold2 = 60;
        int threshold3 = 90;

        //Calculate amount based on units
        double amount = 0;
        if(customer.getUnits()<= threshold1){
            amount= customer.getUnits()*unitPrice1;
        }
        else if (customer.getUnits()<= threshold2){
            amount = threshold1 * unitPrice1 + (customer.getUnits() - threshold1) * unitPrice2;
        }
        else if(customer.getUnits()<=threshold3){
            amount = threshold1 * unitPrice1 + (threshold2 - threshold1) * unitPrice2 +
                    (customer.getUnits() - threshold2) * unitPrice3;
        }
        else if(customer.getUnits()>threshold3){
            amount = threshold1 * unitPrice1 + (threshold2 - threshold1) * unitPrice2 +
                    (threshold3 - threshold2) * unitPrice3 + (customer.getUnits() - threshold3) * unitPrice4;
        }
        else{
            return null;
        }

        //Apply discount based on customer type
        double discount =0;
        if ("silver".equalsIgnoreCase(customer.getType())) {
            discount = 0.05 * amount;
        } else if ("gold".equalsIgnoreCase(customer.getType())) {
            discount = 0.1 * amount;
        }

        //Calculate Final bill
        double finalBill =amount-discount;

        //Set values to bill object
        bill.setAmount(amount);
        bill.setDiscount(discount);
        bill.setFinalBill(finalBill);

        return bill;

    }
}
