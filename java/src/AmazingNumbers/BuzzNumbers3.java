package AmazingNumbers;

import java.util.Scanner;

/*
    Ask a user to enter a natural number.
    If the number is not natural, print an error message.
    Calculate and print the parity of the number.
    Check whether is the number is a Buzz number and print the explanation.
    Finish the program after printing the message.

    - buzz nums = num divis by 7 or end with 7

    output:
            Properties of 14
                even: true
                 odd: false
                buzz: true
                duck: false

    issues I had:
        use while(true) instead of setting a boolean parameter than is set default to false and then true with valid
        input
 */
public class BuzzNumbers3 {
    public static void main(String[] args) {

        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.""");

        while (true) {
            System.out.print("\nEnter a request: ");
            Scanner scanner = new Scanner(System.in);
            long input = scanner.nextLong();
            String convertNum = Long.toString(input);
            boolean divisibleBy7 = input % 7 == 0;
            boolean endsWith7 = input % 10 == 7;
            if (input == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (input > 0) {
                System.out.printf("\nProperties of %s\n", (input));
                System.out.println("\teven: " + (input % 2 == 0));
                System.out.println("\todd: " + (input % 2 != 0));
                System.out.println("\tbuzz: " + (input % 7 == 0 || input % 10 == 7));
                System.out.println("\tduck: " + String.valueOf(input).contains("0"));
                System.out.println("palindromic: " + palindromic(convertNum));
            } else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }

    public static boolean palindromic(String val) {
        StringBuilder sb = new StringBuilder(val).reverse();
        if (sb.toString().equals(val)){
            return true;
        }
        return false;
    }
}