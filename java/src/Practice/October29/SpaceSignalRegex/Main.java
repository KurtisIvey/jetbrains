package Practice.October29.SpaceSignalRegex;

import java.util.Scanner;

public class Main {
    public static String[] decipherCosmicSignal(String[] spaceSignalArray) {
        // Create a new array to store the deciphered signals
        String[] decipheredSignals = new String[spaceSignalArray.length];

        // Iterate through the spaceSignalArray and replace tildes with empty strings using a regular expression
        for (int i = 0; i < spaceSignalArray.length; i++) {
            decipheredSignals[i] = spaceSignalArray[i].replaceAll("~", "");
        }

        return decipheredSignals;
    }


    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] encryptedSpaceSignalArray = scanner.nextLine().split("\\s");
        String[] spaceSignalArray = decipherCosmicSignal(encryptedSpaceSignalArray);
        StringBuilder spaceMessage = new StringBuilder();
        for (String signal : spaceSignalArray) {
            spaceMessage.append(signal).append("\s");
        }
        System.out.println(spaceMessage.toString().trim());
    }
}
