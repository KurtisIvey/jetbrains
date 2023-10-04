package Bulk;

import java.util.Scanner;

public class LargestNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int largest = 0;
        // follow while with whitespace
        while (scanner.hasNextInt()) {
            int scanned = scanner.nextInt();
            // if must be followed by whitespace
            if (scanned > largest) {
                largest = scanned;
            }
        }
        System.out.println(largest);
    }
}
