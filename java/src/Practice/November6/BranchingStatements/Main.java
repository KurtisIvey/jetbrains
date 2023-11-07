package Practice.November6.BranchingStatements;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printSequence(n); // Call the printSequence method with the input value n.
    }

    public static void printSequence(int n) {
        int num = 1; // Initialize a variable num to 1 to start the sequence with 1.
        // num is incremented in the 1st loop
        for (int i = 1; i <= n; num++) { // Loop until n elements have been printed.
            for (int j = 0; j < num && i <= n; j++) {
                // Inner loop: Print num a number of times equal to its value
                System.out.print(num + " "); // Print the current number with a space.
                i++; // Increment i to keep track of the number of printed elements.
            }
        }
    }
}