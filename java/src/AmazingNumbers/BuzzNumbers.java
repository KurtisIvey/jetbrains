package AmazingNumbers;

import java.util.Scanner;

/*
    Ask a user to enter a natural number.
    If the number is not natural, print an error message.
    Calculate and print the parity of the number.
    Check whether is the number is a Buzz number and print the explanation.
    Finish the program after printing the message.

    - buzz nums = num divis by 7 or end with 7
 */
public class BuzzNumbers {
    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();


        boolean divisibleBy7 = input % 7 == 0;
        boolean endsWith7 = input % 10 == 7;
        if (input > 0) {
            if (divisibleBy7 || endsWith7) {
                System.out.println("It is a Buzz number.");
                System.out.printf("Explanation:\n%s", input);
                if (divisibleBy7 && endsWith7) {
                    System.out.println(" is divisible by 7 and ends with 7.");
                } else if (divisibleBy7) {
                    System.out.println(" is divisible by 7.");
                } else {
                    System.out.println(" ends with 7.");
                }
            } else {
                System.out.println("It is not a Buzz number.");
                System.out.printf("Explanation:\n%s is neither divisible by 7 nor does it end with 7.", input);
            }

            if (input % 2 == 0) {
                System.out.println("This number is Even.");
            } else {
                System.out.println("This number is Odd.");
            }
        } else {
            System.out.println("This number is not natural!");
        }
    }


}
