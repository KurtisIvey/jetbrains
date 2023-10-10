package October10.FloatingPoints;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double g = 9.8;
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double density = scanner.nextDouble();
        double height = scanner.nextDouble();
        double output =  g * density * height;
        System.out.println(output);
    }
}
