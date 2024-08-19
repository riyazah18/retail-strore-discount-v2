package com.retailstore.service;

import com.retailstore.model.Bill;
import com.retailstore.model.User;
import com.retailstore.model.UserType;
import com.retailstore.service.discount.Discount;
import com.retailstore.service.discount.FlatDiscount;
import com.retailstore.service.discount.PercentageDiscount;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiscountService {

    private final Discount percentageDiscount;
    private final Discount flatDiscount;


    public DiscountService() {
        this.percentageDiscount = new PercentageDiscount();
        this.flatDiscount = new FlatDiscount();
    }

    public double calculateNetPayableAmount(Bill bill, User user) {
        double percentageDiscountAmount = percentageDiscount.apply(bill, user);
        double flatDiscountAmount = flatDiscount.apply(bill, user);
        return bill.getTotalAmount() - percentageDiscountAmount - flatDiscountAmount;
    }
}
