package Bulk;

import java.util.Scanner;

public class RelationalOperatorsDoesntEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        // oracle standard requires separate vars, no parentheses either between relation operators
        boolean areDistinct = a != b && a != c && b != c;
        System.out.println(areDistinct);
    }
}
