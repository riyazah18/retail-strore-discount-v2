package com.retailstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class Item {
    private String name;
    private double price;
    private boolean isGrocery;
}
