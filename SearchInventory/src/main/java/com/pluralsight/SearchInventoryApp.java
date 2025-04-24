package com.pluralsight;

import com.pluralsight.domain.Book;
import com.pluralsight.domain.Product;
import com.pluralsight.utils.FileReaderUtils;
import com.pluralsight.utils.Printer;

import java.util.Comparator;
import java.util.List;

public class SearchInventoryApp {
    public static void main(String[] args) {
        printBooks();
        printDelimiter();
        printProductsFromCvsFile();
    }

    private static void printProductsFromCvsFile() {
        try (FileReaderUtils fileReaderUtils = new FileReaderUtils("DataFiles/products.csv")) {
            System.out.println("Products from CVS file");
            System.out.println("-".repeat(150));
            fileReaderUtils.getObjectListFromCvsFile(Product::new).stream()
                    .sorted(Comparator.comparing(Product::getName))
                    .forEach(new Printer<>()::printObjectWithLineBelow);

        }
    }

    private static void printDelimiter() {
        System.out.println("-".repeat(150));
        System.out.println("-".repeat(150));
        System.out.println("-".repeat(150));
        System.out.println("-".repeat(150));
    }

    private static void printBooks() {
        System.out.println("Books listed in code");
        System.out.println("-".repeat(150));
        getBooksListedInCode().stream()
                .sorted(Comparator.comparing(Book::getName))
                .forEach(new Printer<>()::printObjectWithLineBelow);
    }

    public static List<Book> getBooksListedInCode() {
        return List.of(
                new Book(1, "Effective Java", 45.00f),
                new Book(2, "Java Concurrency in Practice", 50.00f),
                new Book(3, "Clean Code", 40.00f),
                new Book(4, "Java: The Complete Reference", 60.00f),
                new Book(5, "Head First Java", 35.00f),
                new Book(6, "Java: A Beginner's Guide", 30.00f),
                new Book(7, "Java in a Nutshell", 55.00f),
                new Book(8, "Java Performance: The Definitive Guide", 70.00f),
                new Book(9, "Multithreading", 60.00f),
                new Book(10, "Spring in Action", 50.00f)
        );
    }
}