package BullsAndCows;

import java.security.SecureRandom;
import java.util.*;


public class Stage7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secretCodeLength = getValidInput(scanner, "Input the length of the secret code:");

        int symbolAmount = getValidInput(scanner, "Input the number of possible symbols in the code:");
        if (secretCodeLength < 1 || secretCodeLength > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %s because there aren't enough unique digits.", secretCodeLength);
        } else if (symbolAmount > 36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
        } else if (secretCodeLength > symbolAmount) {
            System.out.printf("Error: it's not possible to generate a code with a length of %S with %s unique symbols.\n", secretCodeLength, symbolAmount);
        } else {
            playGame(secretCodeLength, symbolAmount);
        }
    }

    public static void playGame(int secretCodeLength, int symbolAmount) {
        String secretCode = generateRandomSecretCode(secretCodeLength, symbolAmount);
        System.out.println(secretCode);  // You might want to remove this line in the final version
        System.out.println("Okay, let's start a game!");
        int turn = 1;

        while (true) {
            System.out.printf("Turn %d:\n", turn);
            Scanner scanner = new Scanner(System.in);
            String guess = scanner.nextLine();

            if (guess.equals(secretCode)) {
                String bullString = secretCodeLength > 1 ? "bulls" : "bull";
                System.out.printf("\nGrade: %s %s\n", secretCodeLength, bullString);
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

            turn++;
            process(guess, secretCode);
        }
    }

    private static String generateRandomSecretCode(int length, int symbolAmount) {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        System.out.println("The secret is prepared: " + "*".repeat(length) + " (0-" + (symbolAmount > 10 ? "9, a-" + characters.charAt(symbolAmount - 1) : characters.charAt(symbolAmount - 1))
                + ").");
        List<Character> charList = new ArrayList<>();
        String permittedCharacters = characters.substring(0, symbolAmount - 1);
        // Convert the permitted characters string into a list of characters
        for (char c : permittedCharacters.toCharArray()) {
            charList.add(c);
        }

        Collections.shuffle(charList, new SecureRandom()); // Shuffle the list randomly
        StringBuilder secretCode = new StringBuilder();

        // Add the first character to the secret code
        secretCode.append(charList.get(0));

        // Add the remaining (length - 1) unique characters to the secret code
        for (int i = 1; i < length; i++) {
            secretCode.append(charList.get(i));
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

    public static int getValidInput(Scanner scanner, String prompt) {
        int input = -1; // Initialize input with -1
        String userInput;
        do {
            System.out.println(prompt);
            userInput = scanner.next();
            if ("0".equals(userInput)) {
                System.out.println("Error: 0 is not a valid input. Exiting the application.");
                System.exit(1); // Exit the application
            } else if (!userInput.matches("\\d+")) {
                System.out.printf("Error: \"%s\" isn't a valid number.\n", userInput);
                System.exit(1); // Exit the application
            } else {
                input = Integer.parseInt(userInput);
            }
        } while (!userInput.matches("\\d+") || input <= 0);
        return input;
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
    }}

