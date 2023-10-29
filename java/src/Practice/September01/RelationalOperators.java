package Practice.September01;

import java.util.Scanner;

public class RelationalOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input < 10) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
