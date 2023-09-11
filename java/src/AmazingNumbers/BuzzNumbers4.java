package AmazingNumbers;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Welcome users;
    Display the instructions;
    Ask for a request;
    If a user enters zero, terminate the program;
    If a user enters an empty request, print the instructions;
    If numbers are not natural, print an error message;
    If one number is entered, calculate and print the properties of this number;
    For two numbers, print the list of numbers with properties;
        take input as string, split via a space into an array. 1st is starting num, second is increments
    Once the request is processed, continue execution from step 3.
 */
public class BuzzNumbers4 {
    public static void main(String[] args) {

        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - separate the parameters with one space;
                - enter 0 to exit.""");

        Scanner scanner = new Scanner(System.in);
        ;
        while (true) {
            System.out.print("\nEnter a request: ");
            String inputLine = scanner.nextLine();

            if (inputLine.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else if (inputLine.isEmpty()) {
                printInstructions();
                continue;
            }

            String[] tokens = inputLine.split(" ");

            if (tokens.length == 1 && isNaturalNumber(tokens[0])) {
                long number = Long.parseLong(tokens[0]);
                processSingleNumber(number);
            } else if (tokens.length == 2 && isNaturalNumber(tokens[0]) && isNaturalNumber(tokens[1])) {
                long start = Long.parseLong(tokens[0]);
                int count = Integer.parseInt(tokens[1]);
                processNumberList(start, count);
            } else if (Long.parseLong(tokens[0]) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (Long.parseLong(tokens[1]) < 0) {
                System.out.println("The second parameter should be a natural number.");

            } else {
                printInstructions();
            }
        }
    }

    public static boolean isNaturalNumber(String input) {
        return input.matches("\\d+");
    }

    public static void processSingleNumber(long number) {
        System.out.printf("\nProperties of %d%n", number);
        System.out.println("\tbuzz: " + isBuzz(number));
        System.out.println("\tduck: " + isDuck(number));
        System.out.println("\tpalindromic: " + isPalindromic(number));
        System.out.println("\tgapful: " + isGapful(number));
        System.out.println("\teven: " + isEven(number));
        System.out.println("\todd: " + isOdd(number));
    }

    public static void processNumberListLine(long number) {
        ArrayList<String> stringList = new ArrayList<>();
        if (isBuzz(number)) {
            stringList.add("buzz");
        }
        if (isDuck(number)) {
            stringList.add("duck");
        }
        if (isPalindromic(number)) {
            stringList.add("palindromic");
        }
        if (isGapful(number)) {
            stringList.add("gapful");
        }
        if (isEven(number)) {
            stringList.add("even");
        }
        if (isOdd(number)) {
            stringList.add("odd");
        }
        String result = join(stringList, ", ");
        String line = number + " is" + result;
        System.out.println(line);
    }
    public static void processNumberList(long start, int count) {
        if (count < 0) {
            System.out.println("The second parameter should be a natural number.");
        } else {
            for (int i = 0; i < count; i++) {
                processNumberListLine(start);
                start++;
            }
        }
    }

    public static boolean isPalindromic(long number) {
        String numberStr = String.valueOf(number);
        return numberStr.equals(new StringBuilder(numberStr).reverse().toString());
    }

    public static boolean isBuzz(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isDuck(long number) {
        return String.valueOf(number).contains("0");
    }

    public static boolean isEven(long number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(long number) {
        return !isEven(number);
    }

    public static boolean isGapful(long number) {
        String numberStr = String.valueOf(number);
        if (numberStr.length() < 3) {
            return false;
        }
        int divisor = Integer.parseInt(numberStr.charAt(0) + "" + numberStr.charAt(numberStr.length() - 1));
        return number % divisor == 0;
    }

    public static String join(ArrayList<String> list, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i < list.size() - 1) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }

    public static void printInstructions() {
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - separate the parameters with one space;
                - enter 0 to exit.""");
    }
}