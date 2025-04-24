package com.pluralsight.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String sku;
    private String name;
    private float price;
    private String department;

    public Product(String csvLine) {
        String[] parts = csvLine.split("\\|");
        this.sku = parts[0];
        this.name = parts[1];
        this.price = Float.parseFloat(parts[2]);
        this.department = parts[3];
    }

    @Override
    public String toString() {
        return String.format("Product{sku='%s', name='%s', price=%.2f, department='%s'}", sku, name, price, department);
    }
}
