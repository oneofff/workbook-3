package com.pluralsight.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
   private int id; 
   private String name;  
   private float price;


   @Override
    public String toString() {
        return String.format("Book{id=%d, name='%s', price=%.2f}", id, name, price);
    }
}