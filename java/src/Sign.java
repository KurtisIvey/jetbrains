import java.util.Scanner;

public class Sign {

    public static String sign (int number) {
        // ternary implementation. All types returned must be the same
        return number > 0 ? "+1" : number == 0 ? "0" : "-1";
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}