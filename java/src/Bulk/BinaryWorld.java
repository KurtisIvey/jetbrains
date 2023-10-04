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
public class BinaryWorld {
    public static void main(String[] args) {
        System.out.print("Input string: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder binaryStringBuilder = new StringBuilder("The result: ");

        for(int i = 0; i <input.length();i++) {
            char character = input.charAt(i);
            int asciiValue = (int) character;
            String binary = Integer.toBinaryString(asciiValue);
            while (binary.length() < 7) {
                binary = "0" + binary;
            }
            binaryStringBuilder.append("\n").append(input.charAt(i)).append(" = ").append(binary);
        }
        System.out.println(binaryStringBuilder.toString());
    }
}
