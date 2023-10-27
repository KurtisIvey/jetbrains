package SmartCalculator.Stage2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // take whole line as input to split into array
        while (true) {
            String inputLine = scanner.nextLine();
            String[] nums = inputLine.split(" ");
            if (nums[0].equals("/exit")) {
                System.out.println("Bye!");
                break;
            } else if (nums[0].isEmpty()) {
                continue;
            } else {
                System.out.println(sumStringArray(nums));
                continue;
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
