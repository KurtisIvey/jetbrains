package September11;

import java.util.Scanner;

public class LoveOfBigLetters {
    public static String upperEvenLetters(String message) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(messageChar));
            } else {
                sb.append(messageChar);
            }
        }
        return sb.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}
