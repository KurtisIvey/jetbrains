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

        System.out.print("\nEnter a request: ");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        // split input into array, first index is num, second is incrementation amt
        String[] tokens = inputLine.split(" ");
        while (true) {

            long input = Long.parseLong(tokens[0]);
            boolean divisibleBy7 = input % 7 == 0;
            boolean endsWith7 = input % 10 == 7;
            if (input == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (input > 0) {
                if (tokens.length == 1) {
                    System.out.printf("\nProperties of %s\n", (input));
                    System.out.println("\tbuzz: " + buzz(input));
                    System.out.println("\tduck: " + String.valueOf(input).contains("0"));
                    System.out.println("palindromic: " + palindromic(tokens[0]));
                    System.out.println("gapful: " + gapful(tokens[0]));
                    System.out.println("\teven: " + (input % 2 == 0));
                    System.out.println("\todd: " + (input % 2 != 0));
                } else {
                    int increment = Integer.parseInt(tokens[1]);
                    int num = Integer.parseInt(tokens[0]);
                    int i = 0;
                    while(true) {
                        if(i == increment){
                            break;
                        }
                        String convertNum = Integer.toString(num);
                        ArrayList<String> stringList = new ArrayList<>();
                        if (buzz(num)) {
                            stringList.add("buzz");
                        }
                        if (String.valueOf(num).contains("0")) {
                            stringList.add("duck");
                        }
                        if (palindromic(convertNum)) {
                            stringList.add("palindromic");
                        }
                        if (gapful(tokens[0])) {
                            stringList.add("gapful");
                        }
                        if (num % 2 == 0) {
                            stringList.add("even");
                        }
                        if (num % 2 != 0) {
                            stringList.add("odd");
                        }
                        String result = join(stringList, ", ");
                        String line = num + " is" + result;
                        System.out.println(line);
                        num = num + 1;
                        i++;
                    }
                }

            } else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }

    public static boolean palindromic(String val) {
        StringBuilder sb = new StringBuilder(val).reverse();
        if (sb.toString().equals(val)) {
            return true;
        }
        return false;
    }

    public static boolean buzz(long val) {
        boolean divisibleBy7 = val % 7 == 0;
        boolean endsWith7 = val % 10 == 7;
        return divisibleBy7 || endsWith7;
    }

    public static boolean gapful(String val) {
        if (val.length() < 3) {
            // A gapful number requires at least 3 digits, so return false for shorter strings.
            return false;
        }
        String gapfulDivider = val.charAt(0) + String.valueOf(val.charAt(val.length() - 1));
        int gapfulDividerAsInt = Integer.parseInt(gapfulDivider);
        int valAsInt = Integer.parseInt(val);
        return valAsInt % gapfulDividerAsInt == 0;
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
}