package BullsAndCows;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        // The secret code is prepared: ****.
        String secretCode = "9305";
        System.out.println("The secret code is prepared: ****.\n");

        while (true) {

            int turn = 1;
            System.out.printf("\nTurn %d. Answer:",turn);
            Scanner scanner = new Scanner(System.in);
            String guess = scanner.nextLine();
            if(guess.equals(secretCode)) {
                System.out.printf("%s\n", secretCode);
                System.out.println("Grade: 4 bulls.");
                System.out.printf("Congrats! The secret code is %s.", secretCode);

                break;
            } else {
                process(guess, secretCode);
            }
        }
//
//        // Turn 6. Answer:
//        System.out.println("Turn 6. Answer:");
//        System.out.println("9205");
//        System.out.println("Grade: 3 bulls.\n");
//
//        // Turn 7. Answer:
//        System.out.println("Turn 7. Answer:");
//        System.out.println("9305");
//        System.out.println("Grade: 4 bulls.");
//        System.out.println("Congrats! The secret code is 9305.");
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
