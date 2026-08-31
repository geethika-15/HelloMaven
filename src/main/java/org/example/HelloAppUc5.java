package org.example;

public class HelloAppUc5 {
    public static void main(String[] args) {

        // Check if no arguments are passed
        if (args.length == 0) {
            System.out.println("Hello, World!");
        } else {
            // Enhanced for loop (for-each loop)
            for (String name : args) {
                System.out.println("Hello, " + name + "!");
            }
        }
    }
}

