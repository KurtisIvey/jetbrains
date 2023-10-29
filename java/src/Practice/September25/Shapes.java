package Practice.September25;

import java.util.Scanner;

public class Shapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int input = scanner.nextInt();
        String text = "You have chosen a ";
        switch (input) {
            case 1:
                System.out.println(text + "square");
                break;
            case 2:
                System.out.println(text + "circle");
                break;
            case 3:
                System.out.println(text + "triangle");
                break;
            case 4:
                System.out.println(text + "rhombus");
                break;
            default:
                System.out.println("There is no such shape!");
        }
    }
}
