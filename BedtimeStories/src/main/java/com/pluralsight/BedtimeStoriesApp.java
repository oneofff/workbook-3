package com.pluralsight;

import java.io.InputStream;
import java.util.Scanner;

public class BedtimeStoriesApp {
    private static final Scanner console = new Scanner(System.in);

    private static final String GOLDILOCKS_FILE = "hansel_and_gretel.txt";
    private static final String HANSEL_AND_GRETEL_FILE = "hansel_and_gretel.txt";
    private static final String PATH = "DataFiles/";

    public static void main(String[] args) {
        System.out.println("Choose a bedtime story:");
        System.out.println("1. Goldilocks");
        System.out.println("2. Hansel and Gretel");
        String story = console.nextLine();


        if (story.equals("1")) {
            readFile(GOLDILOCKS_FILE);
        } else if (story.equals("2")) {
            readFile(HANSEL_AND_GRETEL_FILE);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static void readFile(String fileName) {
        InputStream inputStream = BedtimeStoriesApp
                .class
                .getClassLoader()
                .getResourceAsStream(PATH + fileName);
        if (inputStream == null) {
            System.out.println("No such story");
            return;
        }
        try (Scanner fileScanner = new Scanner(inputStream)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        }
    }
}