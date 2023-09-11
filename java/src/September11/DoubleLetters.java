package September11;

import java.util.Scanner;

public class DoubleLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(input.charAt(i)).append(input.charAt(i));
        }
        System.out.print(output.toString());
    }
}
