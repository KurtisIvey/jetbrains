import java.util.Scanner;

/**
 * Find how many seconds passed between the two moments of time on the same day.
 * You are given the integer values representing these moments: hours, minutes and seconds for each of them. It is guaranteed that the earlier moment goes first in the input.
 * Input data format
 * The program gets the input of six integers: three defining the first moment of time in hours, minutes, seconds, and the other three defining the second one.
 * For example, six numbers 1, 2, 30, 15, 21, 1 will represent two moments of time: 1:02:30 am and 3:21:01 pm (or just 15:21:01).
 * Output data format
 * Just one number: seconds between these two moments of time. It's 51511 (14 hours, 18 minutes and 31 seconds) in our example.
 * */
public class SubtractTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int hour1 = scanner.nextInt();
        int minute1 = scanner.nextInt();
        int second1 = scanner.nextInt();
        int hour2 = scanner.nextInt();
        int minute2 = scanner.nextInt();
        int second2 = scanner.nextInt();

        // Calculate time in seconds for each moment
        int timeInSeconds1 = hour1 * 3600 + minute1 * 60 + second1;
        int timeInSeconds2 = hour2 * 3600 + minute2 * 60 + second2;

        // Calculate time difference in seconds
        int timeDifferenceInSeconds = timeInSeconds2 - timeInSeconds1;

        System.out.println(timeDifferenceInSeconds);

    }
}
