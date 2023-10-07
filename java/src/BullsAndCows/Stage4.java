package bullscows;

import java.security.SecureRandom;
import java.util.*;


public class Stage4 {
    public static void main(String[] args) {
        System.out.print("Please, enter the secret code's length:\n");
        Scanner scanner = new Scanner(System.in);
        int secretCodeLength = scanner.nextInt();
        int turn = 1;
        if (secretCodeLength > 10 || secretCodeLength < 1) {
            System.out.printf("Error: can't generate a secret number with a length of %s because there aren't enough unique digits.", secretCodeLength);
        } else {
            String secretCode = generateRandomSecretCode(secretCodeLength);
            System.out.println("Okay, let's start a game!");
            while (true) {
                System.out.printf("Turn %d:\n", turn);
                Scanner scanner2 = new Scanner(System.in);
                String guess = scanner2.nextLine();
                if (guess.equals(secretCode)) {
                    String bullString = secretCodeLength > 1 ? "bulls" : "bull";
                    System.out.printf("%s\n", secretCode);
                    System.out.printf("\nGrade: %s %s", secretCodeLength, bullString);
                    System.out.println("Congratulations! You guessed the secret code.");
                    break;
                }
                turn++;
                process(guess, secretCode);
            }
        }
    }

    private static String generateRandomSecretCode(int length) {
        List<Integer> digits = new ArrayList<>();
        // Fill the list with digits from 1 to 9 (excluding 0)
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits, new SecureRandom()); // Shuffle the list randomly
        StringBuilder secretCode = new StringBuilder();
        // Add the first digit (non-zero) to the secret code
        secretCode.append(digits.get(0));
        // Add the remaining (length - 1) unique digits to the secret code
        for (int i = 1; i < length; i++) {
            secretCode.append(digits.get(i));
        }
        return secretCode.toString();
    }

    public static void process(String guess, String secretCode) {
        int similarChars = countSimilarChars(secretCode, guess);
        int bulls = countSimilarCharAtIndex(secretCode, guess);
        String bullString = bulls == 1 ? "bull" : "bulls";
        int cows = similarChars - bulls;
        String cowString = cows == 1 ? "cow" : "cows";
        if (bulls > 0 && cows == 0) { // bulls only no cows
            System.out.printf("Grade: %s %s\n", bulls, bullString);
        } else if (bulls == 0 && cows > 0) { // cows only no bulls
            System.out.printf("Grade: %s %s\n", cows, cowString);
        } else if (bulls > 0 && cows > 0) { // bulls & cows
            System.out.printf("Grade: %s %s and %s %s\n", bulls, bullString, cows, cowString);
        } else { // nada
            System.out.println("none");
        }
    }

    public static int countSimilarCharAtIndex(String secretCode, String guess) {
        int count = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == guess.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countSimilarChars(String secretCode, String guess) {
        int count = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            char char1 = secretCode.charAt(i);

            // Check if char1 exists in str2
            if (guess.indexOf(char1) != -1) {
                count++;
            }
        }
        return count;
    }

    public static String stringOutput(int item, String type) {
        if (item == 1) {
            return item + " " + type;
        } else if (item > 1) {
            return item + " " + type;
        }
        return null;
    }
}
