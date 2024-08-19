package com.retailstore.controller;

import com.retailstore.model.Bill;
import com.retailstore.model.User;
import com.retailstore.model.UserType;
import com.retailstore.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/net-amount")
    public double calculateNetPayableAmount(@RequestBody Bill bill, @RequestParam Long userId) {
        // We would fetch the user from the DB in a real scenario
        User user = new User(); // Mocked for simplicity
        user.setId(userId);
        user.setUserType(UserType.EMPLOYEE);
        return billService.getNetPayableAmount(bill, user);
    }
}
