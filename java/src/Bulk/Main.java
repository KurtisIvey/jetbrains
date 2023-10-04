package Bulk;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();  // Read an integer input from the user

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();  // Read another integer input from the user
        System.out.println(k / n);
    }
}
