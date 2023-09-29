package September28;

import java.util.Scanner;

public class FizzBuzz {
    // first input is beginning, second is end of interval
    // print on new ln
    // increment by 1, if num divisible by 3 == Fizz, divisible by 5 == Buzz, if divisible by 3 && 5 == FizzBuzz
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        for (int i = start; i <= end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
