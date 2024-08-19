package com.retailstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@Builder
public class Bill {
    private List<Item> items;
    private double totalAmount;

    public double getTotalNonGroceryAmount() {
        return items.stream().filter(item -> !item.isGrocery()).mapToDouble(Item::getPrice).sum();
    }
}
