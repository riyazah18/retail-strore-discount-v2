package com.retailstore.service.discount;

import com.retailstore.model.Bill;
import com.retailstore.model.User;

public interface Discount {
    double apply(Bill bill, User user);
}
