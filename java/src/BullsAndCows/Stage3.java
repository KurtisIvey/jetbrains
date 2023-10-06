package bullscows;

import java.security.SecureRandom;
import java.util.*;


public class Stage3 {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int secretCodeLength = scanner.nextInt();
            if (secretCodeLength > 10) {
                System.out.printf("Error: can't generate a secret number with a length of %s because there aren't enough unique digits.", secretCodeLength);
                break;
            } else {
                String secretCode = generateRandomSecretCode(secretCodeLength);
                System.out.printf("The random secret number is %s.%n", secretCode);
                break;
            }



//            int turn = 1;
//            System.out.printf("\nTurn %d. Answer:",turn);
//            Scanner scanner = new Scanner(System.in);
//            String guess = scanner.nextLine();
//            if(guess.equals(secretCode)) {
//                System.out.printf("%s\n", secretCode);
//                System.out.println("Grade: 4 bulls.");
//                System.out.printf("Congrats! The secret code is %s.", secretCode);
//
//                break;
//            } else {
//                process(guess, secretCode);
//            }
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
    public static void process (String guess, String secretCode) {
        int similarChars = countSimilarChars(secretCode, guess);
        int similarCharsAtIndex = countSimilarCharAtIndex(secretCode, guess);
        int cows = similarChars - similarCharsAtIndex;
        if(similarCharsAtIndex > 0 && cows == 0) {
            System.out.printf("Grade: %s bulls(s). The secret code is %s.", similarCharsAtIndex, secretCode);
        } else if( similarCharsAtIndex == 0 && cows > 0) {
            System.out.printf("Grade: %s cow(s)", cows);

        } else if( similarCharsAtIndex > 0 && cows > 0) {
            System.out.printf("Grade: %s bull(s) and %s cow(s). The secret code is %s.", similarCharsAtIndex, cows, secretCode );
        } else {
            System.out.printf("Grade: None. The secret code is %s", secretCode);
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
        if( item == 1) {
            return item + " " + type;
        }else if (item > 1) {
            return item + " " + type;
        }
        return null;
    }
}
