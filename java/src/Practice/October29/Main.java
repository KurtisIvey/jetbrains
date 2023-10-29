package Practice.October29;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        /* write your code here */
        boolean isValid = isValidVehicleRegistration(regNum);
        System.out.println(isValid);
    }

    public static boolean isValidVehicleRegistration(String input) {
        // Define the regular expression pattern for a valid vehicle registration number
        String pattern = "^[A|B|E|K|M|H|O|P|C|T|Y|X]\\d{3}[A|B|E|K|M|H|O|P|C|T|Y|X]{2}$";

        // Create a Pattern object
        Pattern regPattern = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regPattern.matcher(input);

        // Check if the input string matches the pattern
        return matcher.matches();
    }
}
