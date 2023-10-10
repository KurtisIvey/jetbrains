package October10.MathLibrary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double output = Math.pow(a, b);
        System.out.println(output);
    }
}
