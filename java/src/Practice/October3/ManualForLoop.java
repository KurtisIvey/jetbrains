package Practice.October3;

import java.util.Scanner;

public class ManualForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int product = 1;
        for (int i = start; i < end; i++) {
            product = product * i;
        }
        System.out.println(product);
    }
}
