package Bulk;

import java.util.Scanner;

public class NumDivisByN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int count = 0;
        for (int i = a; i <= b; i += n) {
            count++;
        }
        System.out.println(count);
    }
}
