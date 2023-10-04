package Bulk;/*
p: massive zero string
r: return conversion into normal text
ep: create 2 strings for storing empty initialized
    use for loop that increments by 2. because all the even indexes indicate whether zero or one
    if 0 (its a 1) add to binary string a 1 that's repeated i + 1 times
    if 00 (its a 0) add to binary string a 0 that's repeated i + 1 times

    // convert to text
    for loop to iterate through binary that increments += 7 on i due to 7 bit binary
    use Integer.parseInt with the argument of binary.substring(i, i+7) with a radix of 2 to convert the char
    add char to text

    finally, print out the text
 */
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