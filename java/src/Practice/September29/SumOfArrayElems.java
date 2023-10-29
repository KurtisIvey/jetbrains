package Practice.September29;

import java.util.Scanner;

public class SumOfArrayElems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Read the array elements
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != size) {
            System.out.println("Input size does not match the number of elements.");
            return;
        }

        int[] arr = new int[size];
        int sum = 0;

        // Parse and sum the elements
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(elements[i]);
            sum += arr[i];
        }

        // Print the sum
        System.out.println(sum);
    }
}
