package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static final String[] QUOTES = {
            "The only limit to our realization of tomorrow is our doubts of today.",
            "The future belongs to those who believe in the beauty of their dreams.",
            "Do not wait to strike till the iron is hot, but make it hot by striking.",
            "Success is not how high you have climbed, but how you make a positive difference to the world.",
            "What lies behind us and what lies before us are tiny matters compared to what lies within us.",
            "The best way to predict the future is to create it.",
            "You miss 100% of the shots you don’t take.",
            "The only way to do great work is to love what you do.",
            "Success usually comes to those who are too busy to be looking for it.",
            "Opportunities don't happen. You create them."
    };
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Enter a number between 1 and " + QUOTES.length + ", " + " or 0 for random quote");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index == 0) {
                    printRandomQuote();
                } else {
                    System.out.println("Your quote is: " + QUOTES[index - 1]);
                }

                System.out.println("Do you want to continue? (y/n)");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter a number between 1 and 10");
            } catch (Exception exception) {
                System.out.println("An error occurred: " + exception.getMessage());
                scanner.nextLine(); // Clear the scanner buffer
            }
        }
    }

    private static void printRandomQuote() {
        int index = (int) (Math.random() * Main.QUOTES.length) + 1; // Generate a random index
        System.out.println("Your random quote is: " + Main.QUOTES[index - 1]);
    }
}