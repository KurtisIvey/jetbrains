import java.util.Scanner;

public class IsLeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        // must be divsible by 4
        boolean divisibleBy4 = year % 4 == 0;
        // must not be divisible by 100
        boolean divisibleBy100 = year % 100 == 0;
        // must be divisible by 400
        boolean divisibleBy400 = year % 400 == 0;

        if (divisibleBy4 && (!divisibleBy100 || divisibleBy400)) {
            System.out.println("Leap");
        } else {
            System.out.println("Regular");
        }
    }
}
