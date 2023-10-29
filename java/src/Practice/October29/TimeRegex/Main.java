package Practice.October29.TimeRegex;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$";

        String time = scanner.nextLine();
        System.out.println(time.matches(regex) ? "YES" : "NO");
    }
}
/*
1.   ^: Anchors the match at the beginning of the string.
       (0[0-9]|1[0-9]|2[0-3]):
2.  0[0-9]: Matches any two-digit number starting with '0', so it matches numbers from '00' to '09'.
    1[0-9]: Matches any two-digit number starting with '1', so it matches numbers from '10' to '19'.
    2[0-3]: Matches any two-digit number starting with '2', but the second digit can be '0', '1', '2', or '3', so it matches numbers from '20' to '23'.
    The | (pipe) symbol acts as an OR operator, so it matches any of the three possibilities.
3.   ":" Matches the colon character literally, which separates the hours and minutes in the time.
4.  ([0-5][0-9]):
    [0-5][0-9]: Matches any two-digit number where the first digit can be '0' to '5' and the second digit can be '0' to '9'. This ensures that the minutes part of the time is in the range '00' to '59'.
5.   $: Anchors the match at the end of the string.

 */