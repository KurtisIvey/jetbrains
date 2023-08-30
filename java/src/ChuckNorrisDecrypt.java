import java.util.Scanner;

public class ChuckNorrisDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        String[] word = scanner.nextLine().split(" ");  // Read input string and split into words
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

        // Binary to Text Conversion
        for (int i = 0; i < binary.length(); i += 7) {  // Process binary in chunks of 7 bits
            // Convert the chunk to an integer, then to a character, and add to text
            char c = (char) Integer.parseInt(binary.substring(i, i + 7), 2);
            text += c;
        }

        System.out.println("The result: ");
        System.out.println(text);  // Print the decrypted text
        scanner.close();
    }
}