import java.util.Scanner;

public class RelationalOperatorsDoesntEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        // oracle standard requires seperate vars, no parentheses either bewteen relation operators
        boolean areDistinct = a != b && a != c && b != c;
        System.out.println(areDistinct);
    }
}
