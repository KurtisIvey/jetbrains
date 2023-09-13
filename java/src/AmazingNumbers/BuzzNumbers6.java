package AmazingNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class BuzzNumbers6 {
    public static void main(String[] args) {

        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - two natural numbers and a property to search for;
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

            // first index is num, second is increment amount
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

            } else if (tokens.length > 2){
                long start = Long.parseLong(tokens[0]);
                int count = Integer.parseInt(tokens[1]);
                String property = tokens[2];
                processPropertyNumberList(start, count, property);
            }else {
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
        System.out.println("\tspy: " + isSpy(number));
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
        if (isSpy(number)) {
            stringList.add("spy");
        }
        String result = join(stringList, ", ");
        String line = number + " is " + result;
        System.out.println(line);
    }

    public static void processNumberList(long start, int count) {
        for (int i = 0; i < count; i++) {
            processNumberListLine(start);
            start++;
        }

    }

    public static String[] processSpecificPropertyLine(long number) {
        // returns arrayList in order to then disqualify in processPropertyNumberList
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
        if (isSpy(number)) {
            stringList.add("spy");
        }

        return stringList.toArray(new String[0]);
    }

    public static void processPropertyNumberList(long start, int count, String property) {
        String propertyLowercase = property.toLowerCase();
        final String[] expectedArray = {"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd"};
        final String availableProperties = "BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD";

        int i = 1;

        if (!isStringInArray(propertyLowercase, expectedArray)) {
            System.out.printf("The property [%s] is wrong.\nAvailable properties: [%s]", property.toUpperCase(), availableProperties);
        } else {
            while(i <= count) {
                String[] stringArray = processSpecificPropertyLine(start);
                if(isStringInArray(propertyLowercase, stringArray)) {
                    processNumberListLine(start);
                    i++;
                }
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

    public static boolean isSpy(long number) {
        // Convert the number to a string to iterate through its digits
        String numStr = String.valueOf(number);

        // Initialize variables to calculate the sum and product of digits
        int sumOfDigits = 0;
        int productOfDigits = 1;

        for (int i = 0; i < numStr.length(); i++) {
            char digitChar = numStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            // Update the sum and product of digits
            sumOfDigits += digit;
            productOfDigits *= digit;
        }

        // Check if the sum of digits is equal to the product of digits
        return sumOfDigits == productOfDigits;
    }

    public static boolean isPerfectSquare(long number) {
        // Calculate the square root
        double squareRoot = Math.sqrt(number);

        // Check if the square root is an integer
        return squareRoot == Math.floor(squareRoot);
    }

    public static boolean IsSpy(long number) {
        // n + 1 must be a perfect square to be a spy
        long nPlus1 = number + 1;

        return isPerfectSquare(nPlus1);
    }

    public static String join(ArrayList<String> list, String delimiter) {
        // joins array list via the delimiter passed through
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i < list.size() - 1) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }

    public static boolean isStringInArray(String input, String[] array) {
        for (String element : array) {
            if (element.equals(input)) {
                return true;
            }
        }
        return false;
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