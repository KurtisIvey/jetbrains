package ChuckNorris;

import java.util.Scanner;

public class CoolerThanChuckNorris {
    // req, ask  users what they want to do, encode/decode/exit
    //     Please input operation (encode/decode/exit):
    // if user inputs operation and misspells it, prints "There is no '<input>' operation", loop by asking input again
    // if user inputs "encode", problem prints "Input string:" to output, read a line and output two lines
    //    output - "Decoded string: ~ followed by actual decoded string
    // if user inputs "exit" , program should say "Bye!" and finish execution by System.close
    public static void main(String[] args) {
        String operation = "";
        boolean properlyEntered = false;
        while (!properlyEntered) {
            System.out.println("Please input operation (encode/decode/exit):");
            Scanner scanner = new Scanner(System.in);
            operation = scanner.nextLine();
            if (operation.equals("encode")) {
                // encode command plus pass through input as arg
                System.out.println("Input string:");
                Scanner scannerEncoded = new Scanner(System.in);
                String input = scanner.nextLine();
                encode(input);
                properlyEntered = true;
                scanner.close();

            } else if(operation.equals("decode")) {
                // encode command plus pass through input as arg
                System.out.println("Input encoded string:");
                Scanner scannerEncoded = new Scanner(System.in);
                String input = scanner.nextLine();
                if (isValidInput((input))) {
                    properlyEntered = true;
                    decode(input);
                    scanner.close();

                } else {
                    System.out.println("not valid");
                }
            } else if(operation.equals("exit")) {
                properlyEntered = true;
                System.out.print("Bye!");
                scanner.close();
            } else {
                System.out.println("There is no '" + operation + "' operation");
            }
        }
    }

    public static boolean isValidInput(String input) {
        // Check if the string contains characters other than '0' and ' ' return false if so.
        // regex to only accept 0 & " " (space char)
        if (!input.matches("[0 ]+")) {
            return false;
        }
        String[] blocks = input.split(" ");
        //The first block of each sequence is not 0 or 00;
        for (String block : blocks) {
            if (block.isEmpty() || block.startsWith("00")) {
                return false;
            }
        }
        // Check if the number of blocks is odd
        if (blocks.length % 2 == 0) {
            return false;
        }
        // should be followed by 0 indicator of 0 or 1 + 7 bits, so should be divisible by 8 as well

        // passes
        return true;
    }

    public static void decode(String encoded) {

        String[] word = encoded.split(" ");  // Read input string and split into words
        String binary = "";  // Initialize an empty string to store binary representation
        String text = "";    // Initialize an empty string to store decrypted text

        // Decryption
        for (int i = 0; i < word.length; i += 2) {  // Process words in pairs
            switch (word[i]) {
                case "0":
                    binary += "1".repeat(word[i + 1].length());  // Add 1s based on the word length
                    break;
                case "00":
                    binary += "0".repeat(word[i + 1].length());  // Add 0s based on the word length
                    break;
            }
        }
        for (int i = 0; i < binary.length(); i += 7) {  // Process binary in chunks of 7 bits
            // Convert the chunk to an integer, then to a character, and add to text
            char c = (char) Integer.parseInt(binary.substring(i, i + 7), 2);
            text += c;
        }


        System.out.println("Decoded string:\n" + text);
        //System.out.println(text);  // Print the decrypted text
    }

    public static void encode(String toEncode) {


        StringBuilder binaryStringBuilder = new StringBuilder();

        for(int i = 0; i <toEncode.length();i++) {
            char character = toEncode.charAt(i);
            int asciiValue = (int) character;
            String binary = Integer.toBinaryString(asciiValue);
            while (binary.length() < 7) {
                binary = "0" + binary;
            }
            binaryStringBuilder.append(binary);
        }
        String binaryConversion = binaryStringBuilder.toString();
        StringBuilder unaryCode = encrypt(binaryConversion);
        String formatted = unaryCode.toString().trim();
        System.out.println("Encoded string:\n" + formatted);
    }
    public static StringBuilder encrypt(String binaryConversion) {
        StringBuilder unaryCode = new StringBuilder("");
        char prevChar = '\0'; // Initialize with a non-valid character

        for (int i = 0; i < binaryConversion.length(); i++) {
            char binaryChar = binaryConversion.charAt(i);

            if (prevChar != binaryChar) {
                if (unaryCode.length() > 0) {
                    unaryCode.append(" "); // Add space between blocks
                }
                unaryCode.append(binaryChar == '0' ? "00 " : "0 ");
                prevChar = binaryChar;
            }

            unaryCode.append("0"); // Append zeros for the count
        }
        return unaryCode;
    }
}
