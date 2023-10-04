package AmazingNumbers;

import java.util.*;


public class BuzzNumbers8pt2 {

    private static final String[] expectedProperties = {"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "square", "sunny", "jumping", "happy", "sad"};
    private static final String availableProperties = "EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD";

    public static void main(String[] args) {

        System.out.println("Welcome to Amazing Numbers!\n");
        printInstructions();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a request: ");
            String inputLine = scanner.nextLine();

            if (inputLine.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else if (inputLine.isEmpty()) {
                printInstructions();
                continue;
            }

            // first index is num, second is increment amount
            String[] tokens = inputLine.split(" ");
            // Create an array to hold properties beyond the second token

            if (tokens.length == 1 && isNaturalNumber(tokens[0])) {
                long number = Long.parseLong(tokens[0]);
                processSingleNumber(number);
            }else if (Long.parseLong(tokens[0]) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (Long.parseLong(tokens[1]) < 0) {
                System.out.println("The second parameter should be a natural number.");
            } else if (tokens.length == 2 && isNaturalNumber(tokens[0]) && isNaturalNumber(tokens[1])) {
                long start = Long.parseLong(tokens[0]);
                int count = Integer.parseInt(tokens[1]);

                for (int i = 0; i < count; i++) {
                    long number = start + i;
                    String[] properties = processProperties(number);
                    String result = join(properties, ", ");
                    String line = number + " is " + result;
                    System.out.println(line);
                }

            } else if (tokens.length > 2 && isNaturalNumber(tokens[0]) && isNaturalNumber(tokens[1])) {
                long start = Long.parseLong(tokens[0]);
                int count = Integer.parseInt(tokens[1]);
                String[] properties = Arrays.copyOfRange(tokens, 2, tokens.length);
                processMultipleProperties(start, count, properties);

            }
             else {
                printInstructions();
            }
        }
    }

    public static void processSingleNumber(long number) {
        System.out.printf("\nProperties of %d%n", number);
        System.out.println("\tbuzz: " + isBuzz(number));
        System.out.println("\tduck: " + isDuck(number));
        System.out.println("\tpalindromic: " + isPalindromic(number));
        System.out.println("\tgapful: " + isGapful(number));
        System.out.println("\teven: " + isEven(number));
        System.out.println("\todd: " + isOdd(number));
        System.out.println("\tspy: " + isSpy(number));
        System.out.println("\tsquare: " + isPerfectSquare(number));
        System.out.println("\tsunny: " + isSunny(number));
        System.out.println("\tjumping: " + isJumping(number));
        System.out.println("\thappy: " + isHappy(number));
        System.out.println("\tsad: " + !isHappy(number));
    }

    public static String[] processProperties(long number) {
        // returns arrayList in order to then disqualify in processPropertyNumberList
        ArrayList<String> stringList = new ArrayList<>();
        if (isBuzz(number)) {
            stringList.add("buzz");
        }
        if (isDuck(number)) {
            stringList.add("duck");
        }
        if (isPalindromic(number)) {
            stringList.add("palindromic");
        }
        if (isGapful(number)) {
            stringList.add("gapful");
        }
        if (isEven(number)) {
            stringList.add("even");
        }
        if (isOdd(number)) {
            stringList.add("odd");
        }
        if (isSpy(number)) {
            stringList.add("spy");
        }
        if (isPerfectSquare(number)) {
            stringList.add("square");
        }
        if (isSunny(number)) {
            stringList.add("sunny");
        }
        if (isJumping(number)) {
            stringList.add("jumping");
        }
        if (isHappy(number)) {
            stringList.add("happy");
        }
        if (!isHappy(number)) {
            stringList.add("sad");
        }

        return stringList.toArray(new String[0]);
    }

    public static void processMultipleProperties(long start, int count, String[] properties) {


        List<String> includedProperties = new ArrayList<>();
        List<String> incorrectProperties = new ArrayList<>();
        List<String> excludedProperties = new ArrayList<>();

        for (String s : properties) {
            String property = s.toLowerCase();
            if (property.startsWith("-")) {
                // remove -
                property = property.substring(1);
                if (!Arrays.asList(expectedProperties).contains(property)) {
                    incorrectProperties.add(property);
                } else {
                    excludedProperties.add(property);
                }
            } else {
                if (!Arrays.asList(expectedProperties).contains(property)) {
                    incorrectProperties.add(property);

                } else {
                    includedProperties.add(property);
                }
            }
        }



        // check for incorrect properties
        if (!incorrectProperties.isEmpty()) {
            if (incorrectProperties.size() == 1) {
                System.out.printf("The property [%s] is wrong.\nAvailable properties: [%s]\n", incorrectProperties.get(0).toUpperCase(), availableProperties);
            } else {
                StringBuilder incorrectPropsSb = new StringBuilder();
                for (String incorrectProp : incorrectProperties) {
                    incorrectPropsSb.append(incorrectProp.toUpperCase()).append(", ");
                } // Remove the trailing ", " from the end
                incorrectPropsSb.setLength(incorrectPropsSb.length() - 2);
                System.out.printf("The properties [%s] are wrong. Available properties: [%s]\n", incorrectPropsSb.toString(), availableProperties);
            }
        }



        // check for mutually exclusive properties
        if (!containsMutuallyExclusiveProperties(includedProperties.toArray(new String[0]),excludedProperties,includedProperties) && !containsMutuallyExclusiveProperties(excludedProperties.toArray(new String[0]), excludedProperties, includedProperties)) {
            for (String includedProp : includedProperties) {
                if (excludedProperties.contains(includedProp)) {
                    // This property is both included and excluded
                    System.out.printf("The request contains mutually exclusive properties: [-%s, %s]\n", includedProp.toUpperCase(),includedProp.toUpperCase());
                    System.out.println("There are no numbers with these properties.");
                    System.out.println();
                }
            }
            int i = 1;
            while (i <= count) {
                String[] stringArray = processProperties(start);

                if (excludedProperties.isEmpty() && containsAllProperties(stringArray, includedProperties)) {
                    String[] propertiesOfNumber = processProperties(start);
                    String result = join(propertiesOfNumber, ", ");
                    String line = start + " is " + result;
                    System.out.println(line);
                    i++;
                } else if (containsAllProperties(stringArray, includedProperties) && !containsAnyProperty(stringArray, excludedProperties)) {
                        String[] propertiesOfNumber = processProperties(start);
                        String result = join(propertiesOfNumber, ", ");
                        String line = start + " is " + result;
                        System.out.println(line);
                        i++;
                    }
                start++;
                if (i > count) {
                    break;
                }
            }
        }
    }

    public static boolean isNaturalNumber(String input) {
        return input.matches("\\d+");
    }

    public static boolean containsProperty(String[] properties, String propertyToCheck) {
        for (String property : properties) {
            if (property.toLowerCase().equals(propertyToCheck)) {
                return true; // Property found in the array
            }
        }
        return false; // Property not found in the array
    }
    public static boolean containsAnyProperty(String[] propertiesToCheck, List<String> properties) {
        // Convert properties to a HashSet for faster lookup
        Set<String> propertySet = new HashSet<>(properties);

        for (String propertyToCheck : propertiesToCheck) {
            if (propertySet.contains(propertyToCheck.toLowerCase())) {
                return true; // Property found in the set
            }
        }
        return false; // Property not found in the set
    }


    private static boolean containsAllProperties(String[] properties, List<String> target) {

        String[] targetProperties = target.toArray(new String[0]); // Convert target list to an array
        // stuck in infinite loop. must intercept
        for (String property : targetProperties) {
            if (!Arrays.asList(properties).contains(property)) {
                return false;
            }
        }
        return true;
    }


    private static Boolean containsMutuallyExclusiveProperties(String[] properties, List<String> excludedProperties, List<String> includedProperties) {
        for (String includedProp : includedProperties) {
            if (excludedProperties.contains(includedProp)) {
                // This property is both included and excluded
                System.out.printf("The request contains mutually exclusive properties: [-%s, %s]\n", includedProp.toUpperCase(),includedProp.toUpperCase());
                System.out.println("There are no numbers with these properties.");
                System.out.println();
                return true;
            }
        }
        // Define mutually exclusive pairs
        if (containsProperty(properties, "even") && containsProperty(properties, "odd")){
            System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
            return true;
        }
        if (containsProperty(properties, "sunny") && containsProperty(properties, "square")){
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
            return true;
        }
        if (containsProperty(properties, "spy") && containsProperty(properties, "duck")){
            System.out.println("The request contains mutually exclusive properties: [SPY, DUCK]");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
            return true;
        }
        return false;
    }


    public static String join(String[] list, String delimiter) {
        // Joins an array of strings using the specified delimiter
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            builder.append(list[i]);
            if (i < list.length - 1) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }

    public static boolean isPalindromic(long number) {
        String numberStr = String.valueOf(number);
        return numberStr.equals(new StringBuilder(numberStr).reverse().toString());
    }

    public static boolean isBuzz(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isDuck(long number) {
        return String.valueOf(number).contains("0");
    }

    public static boolean isEven(long number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(long number) {
        return !isEven(number);
    }

    public static boolean isGapful(long number) {
        String numberStr = String.valueOf(number);
        if (numberStr.length() < 3) {
            return false;
        }
        int divisor = Integer.parseInt(numberStr.charAt(0) + "" + numberStr.charAt(numberStr.length() - 1));
        return number % divisor == 0;
    }

    public static boolean isSpy(long number) {
        // Convert the number to a string to iterate through its digits
        String numStr = String.valueOf(number);

        // Initialize variables to calculate the sum and product of digits
        int sumOfDigits = 0;
        int productOfDigits = 1;

        for (int i = 0; i < numStr.length(); i++) {
            char digitChar = numStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            // Update the sum and product of digits
            sumOfDigits += digit;
            productOfDigits *= digit;
        }

        // Check if the sum of digits is equal to the product of digits
        return sumOfDigits == productOfDigits;
    }

    public static boolean isPerfectSquare(long number) {
        // Calculate the square root
        double squareRoot = Math.sqrt(number);

        // Check if the square root is an integer
        return squareRoot == Math.floor(squareRoot);
    }

    public static boolean isSunny(long number) {
        // n + 1 must be a perfect square to be sunny
        long nPlus1 = number + 1;

        return isPerfectSquare(nPlus1);
    }

    public static Boolean isJumping(long number) {
        // Convert the number to a string to iterate through its digits
        String numStr = String.valueOf(number);

        char prevDigit = numStr.charAt(0);
        for (char digit : numStr.substring(1).toCharArray()) {
            if (Math.abs(digit - prevDigit) != 1) {
                return false;
            }
            prevDigit = digit;
        }
        return true;
    }

    private static long calculateSquareSum(long number) {
        long sum = 0;
        while (number > 0) {
            long digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

    public static boolean isHappy(long number) {
        // Use Floyd's Cycle Detection Algorithm
        long slow = number;
        long fast = number;

        do {
            slow = calculateSquareSum(slow);        // Move one step
            fast = calculateSquareSum(calculateSquareSum(fast));  // Move two steps
        } while (slow != fast);

        // If we reach 1, it's a happy number; otherwise, it's not
        return slow == 1;
    }

    public static void printInstructions() {
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.""");
    }
}
