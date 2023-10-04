package Bulk;

import java.util.Scanner;

public class ArithmeticBasicN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // add result var for readability
        int result = ((((n + 1) * n + 2) * n) + 3); // Added parentheses for proper order
        System.out.println(result);
    }
}
