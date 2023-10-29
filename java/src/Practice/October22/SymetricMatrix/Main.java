package Practice.October22.SymetricMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        // Input the matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Check if the matrix is symmetric
        boolean isSymmetric = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Compare matrix[i][j] with matrix[j][i] (mirrored element)
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                    break; // If not symmetric, break out of the loop
                }
            }
            if (!isSymmetric) {
                break; // If not symmetric, break out of the loop
            }
        }

        // Output the result
        if (isSymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
