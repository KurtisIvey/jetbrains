package October10.Doubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double x = scanner.nextDouble();
        double output = Math.pow(x, 3) + Math.pow(x, 2) + x + 1;
        System.out.println(output);
    }
}
