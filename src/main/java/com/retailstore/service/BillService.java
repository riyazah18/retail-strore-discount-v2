package com.retailstore.service;

import com.retailstore.model.Bill;
import com.retailstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private DiscountService discountService;

    public double getNetPayableAmount(Bill bill, User user) {
        return discountService.calculateNetPayableAmount(bill, user);
    }
}
