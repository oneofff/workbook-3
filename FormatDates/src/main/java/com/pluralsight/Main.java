package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("MMMM d, yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy, hh:mm")));
    }
}