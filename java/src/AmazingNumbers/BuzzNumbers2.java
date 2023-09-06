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
 */
public class BuzzNumbers2 {
    public static void main(String[] args) {

        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();


        boolean divisibleBy7 = input % 7 == 0;
        boolean endsWith7 = input % 10 == 7;
        if (input > 0) {
            System.out.printf("Properties of %s\n", input);
            if (input % 2 == 0) {
                System.out.println("\teven: true");
                System.out.println("\todd: false");

            } else {
                System.out.println("\teven: false");
                System.out.println("\todd: true");

            }
            if (divisibleBy7 || endsWith7) {
                System.out.println("\tbuzz: true");
            } else {
                System.out.println("\tbuzz: false");

            }
            if(Integer.toString(input).contains(String.valueOf("0"))){
                System.out.println("\tduck: true");
            }else {
                System.out.println("\tduck: false");

            }
        } else {
            System.out.println("This number is not natural!");
        }
    }
}

