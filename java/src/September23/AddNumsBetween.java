package September23;

import java.util.Scanner;

public class AddNumsBetween {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = 0;
        while (a < b + 1) {
            sum += a;
            a++;
        }
        System.out.print(sum);
    }
}
