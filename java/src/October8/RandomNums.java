package October8;
import java.util.Scanner;
import java.util.Random;

public class RandomNums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read input values from the user
        int k = input.nextInt(); // Initial seed value
        int n = input.nextInt(); // Number of Gaussian-distributed numbers to generate
        double m = input.nextDouble(); // Threshold value for generated numbers

        // Initialize a random number generator
        Random random = new Random();

        // Loop for generating Gaussian numbers
        for (int i = 0; i < n; i++) {
            // If this is the first iteration, set the seed value for the random generator
            if (i == 0) {
                random = new Random(k);
            }

            // Generate a Gaussian-distributed random number
            double randomNumber = random.nextGaussian();

            // Check if the generated number exceeds the threshold value
            if (randomNumber > m) {
                // If it exceeds, reset the loop counter and increment k
                i = -1; // Reset the counter (-1 because it will be incremented to 0)
                k++; // Increment the seed value
            }
        }

        // Print the final value of k, which is the suitable seed value
        System.out.println(k);
    }
}
