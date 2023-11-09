package SmartCalculator.Stage4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // take whole line as input to split into array
        while (true) {
            String inputLine = scanner.nextLine();
            String[] input = inputLine.split(" ");
            // removes empty spaces in input arr
            String[] filteredArray = Arrays.stream(input)
                    .filter(s -> !s.trim().isEmpty())
                    .toArray(String[]::new);

            if (input[0].equals("/exit")) {
                System.out.println("Bye!");
                break;
            } else if (input[0].equals("/help")) {
                System.out.println("The program calculates the sum of numbers");
            } else if (input[0].isEmpty()) {
                continue;
            } else {
                System.out.print(Arrays.toString(filteredArray));
                //System.out.println(sumStringArray(nums));
                //continue;
            }
        }

    }

    public static int sumStringArray(String[] stringArray) {
        int sum = 0;

        for (String str : stringArray) {
            try {
                int number = Integer.parseInt(str);
                sum += number;
            } catch (NumberFormatException e) {
            }
        }
        return sum;
    }
}
