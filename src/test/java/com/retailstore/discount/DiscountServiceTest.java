package com.retailstore.discount;

import com.retailstore.model.Bill;
import com.retailstore.model.Item;
import com.retailstore.model.User;
import com.retailstore.model.UserType;
import com.retailstore.service.DiscountService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Arrays;

public class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    public void testEmployeeDiscount() {
        User user = User.builder()
                .name("John Doe")
                .userType(UserType.EMPLOYEE)
                .joiningDate(LocalDate.now().minusYears(3))
                .build();
        Bill bill = Bill.builder()
                .items(Arrays.asList(Item.builder()
                                .name("Item1")
                                .price(200)
                                .isGrocery(false)
                                .build(),
                        Item.builder()
                                .name("Item2")
                                .price(100)
                                .isGrocery(true)
                                .build()))
                .totalAmount(300) // Ensure total amount matches
                .build();
        double netAmount = discountService.calculateNetPayableAmount(bill, user);
        assertEquals(125.0, netAmount, 0.01); // Delta of 0.01
    }

    @Test
    public void testFlatDiscountOnly() {
        User user = User.builder()
                .name("John Doe")
                .userType(UserType.CUSTOMER)
                .joiningDate(LocalDate.now())
                .build();
        Bill bill = Bill.builder()
                .items(Arrays.asList(Item.builder()
                        .name("Item1")
                        .price(990)
                        .isGrocery(false)
                        .build()))
                .build();

        double netAmount = discountService.calculateNetPayableAmount(bill, user);
        assertEquals(945.0, netAmount, 0.01); // Delta of 0.01
    }
}
