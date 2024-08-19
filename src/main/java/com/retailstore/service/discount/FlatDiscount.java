package com.retailstore.service.discount;

import com.retailstore.model.Bill;
import com.retailstore.model.User;

public class FlatDiscount implements Discount {

    @Override
    public double apply(Bill bill, User user) {
        return (int)(bill.getTotalAmount() / 100) * 5;
    }
}
