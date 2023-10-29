package Practice.October29.IpAddressRegex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String ipAddress = scanner.nextLine(); // a valid or invalid ip

        boolean isValid = isValidIp(ipAddress);
        System.out.print(isValid ? "YES" : "NO");

    }

    public static boolean isValidIp(String ipAddress) {
        String pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        // Create a Pattern object
        Pattern ipPattern = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = ipPattern.matcher(ipAddress);

        // Check if the input string matches the pattern
        return matcher.matches();
    }
}