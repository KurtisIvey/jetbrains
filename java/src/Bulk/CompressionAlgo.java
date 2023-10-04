package Bulk;/*
p: string of chars
r: output of string with only one char and the number of times its present
ep:
    use pointer method
    create newVar for output stirng
    int pointer = 0 , our pointer
    int count = 1;
    for loop to iterate through

        if str[pointer] == str[i]
            count++
        else
            output.append(pointer).append(count)
            pointer = next char
            count = 1
    return the output or print
 */

import java.util.Scanner;

public class CompressionAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // use next line to grab all text on line instead of just one with next
        String input = scanner.nextLine();
        String encoded = encode(input);
        System.out.println(encoded);

    }

    public static String encode(String input) {
        // stringbuilder as its mutable
        StringBuilder output = new StringBuilder();
        // count
        int count = 0;
        // use char at to keep track of current char, start at first index
        char currentChar = input.charAt(0);
        for (int i = 0; i < input.length(); i++) {
            // tracks current char in for loop, in case need to redefine currentChar
            char nextChar = input.charAt(i);
            if (currentChar == nextChar) {
                count++;
            } else {
                // adds to output string with char and the count of said char
                output.append(currentChar).append(count);
                // redefine current char to nextChar, and reset count to 1 since new char is being tracked
                currentChar = nextChar;
                count = 1;
            }
        }
        // for last char and count to be added if finish for loop
        output.append(currentChar).append(count);
        // return in string format
        return output.toString();
    }
}
