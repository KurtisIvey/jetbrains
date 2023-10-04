package Bulk;/*
p: receive input string
r: return single string of characters leading with "The result: etc etc" each char must following with
    "char = 'binaryRepresentation'" on a new line leading
ep:
    first create String for input
    next, create mutable StringBuilder for output string. initialize val with "The result: "
    for loop to iterate through input string
        in loop, identify char with input.charAt(i)
        convert char into asciiValue with (int) character
        then create binary string, convert asciiValue to binary via Integer.toBinaryString(asciiValue)
        use while loop to add leading zero if binary.length is less than 7
        append to StringBuilder a \n , append char, append " = ", append binary
    Finally, print out ln
 */

import java.util.Scanner;

public class ChuckNorris3 {
    public static void main(String[] args) {
        System.out.print("Input string: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder binaryStringBuilder = new StringBuilder();

        for(int i = 0; i <input.length();i++) {
            char character = input.charAt(i);
            int asciiValue = (int) character;
            String binary = Integer.toBinaryString(asciiValue);
            while (binary.length() < 7) {
                binary = "0" + binary;
            }
            binaryStringBuilder.append(binary);
        }
        String binaryConversion = binaryStringBuilder.toString();
        StringBuilder unaryCode = encrypt(binaryConversion);
        System.out.println(unaryCode.toString().trim());
    }
    public static StringBuilder encrypt(String binaryConversion) {
        StringBuilder unaryCode = new StringBuilder("The result:\n");
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
