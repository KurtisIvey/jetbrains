package Practice.September22;

import java.util.Scanner;

public class CheckVal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int input = scanner.nextInt();
        if (input < 10 && input > 0) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
