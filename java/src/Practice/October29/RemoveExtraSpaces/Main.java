package Practice.October29.RemoveExtraSpaces;

import java.util.Scanner;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String newText = text.replaceAll("\\s+", " ");
        System.out.print(newText);
    }
}
