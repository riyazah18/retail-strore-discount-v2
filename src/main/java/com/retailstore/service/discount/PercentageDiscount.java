package com.retailstore.service.discount;

import com.retailstore.model.Bill;
import com.retailstore.model.User;
import com.retailstore.model.UserType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PercentageDiscount implements Discount {

    @Override
    public double apply(Bill bill, User user) {
        // Percentage-based discounts
        double discount = 0.0;
        if (user.getUserType() == UserType.EMPLOYEE) {
            discount = 0.30;// 30% discount
        } else if (user.getUserType() == UserType.AFFILIATE) {
            discount = 0.10;// 10% discount
        } else if (user.getUserType() == UserType.CUSTOMER &&
                ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDate.now()) > 2) {
            discount = 0.05;// 5% discount
        }
        return bill.getTotalNonGroceryAmount() * discount;
    }
}
