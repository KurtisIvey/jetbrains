package SmartCalculator.Stage5;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // take whole line as input to split into array
        while (true) {
            String inputLine = scanner.nextLine();
            // splits by spaces and also removes whitespace. better than " " since trim not needed
            String[] input = inputLine.split(" ");


            if (input[0].equals("/exit")) {
                System.out.println("Bye!");
                break;
            } else if (input[0].equals("/help")) {
                System.out.println("The program calculates the sum of numbers");
            } else if (input[0].isEmpty()) {
                continue;
            } else {
                //System.out.println(Arrays.toString(input));
                String[] validatedExpression = validateExpression(input);
                if(validatedExpression == null) {
                    System.out.println("Invalid expression");
                } else {
                    int result = evaluateExpression(validatedExpression);
                    System.out.println(result);
                }

            }
        }

    }

    public static String[] validateExpression(String[] expression) {
        // handle consecutive minus by changing to + or - alone by mutating express []
        for (int i = 1; i < expression.length; i += 2) {
            if(expression[i].contains("-") && expression[i].length() % 2 == 0) {
                expression[i] = "+";
            } else if (expression[i].contains("-") && expression[i].length() % 2 == 1) {
                expression[i] = "-";
            } else {
                expression[i] = String.valueOf(expression[i].charAt(0)); // Replace with the desired character or string
            }
        }

        // check if valid numbers odd indexes
        for (int i = 0; i < expression.length; i += 2) {
            expression[i] = removePlusSign(expression[i]); // Remove '+' signs
            if (!isValidNumber(expression[i])) {
                return null; // Return null to indicate an invalid expression
            }
        }

        // Validate even indexes (+ or -)
        for (int i = 1; i < expression.length; i += 2) {
            if (!isValidOperator(expression[i])) {
                return null; // Return null to indicate an invalid expression
            }
        }
        return expression;
    }

    public static int evaluateExpression(String[] validExpression) {
        // set initial result to first int in expression arr
        int result = Integer.parseInt(validExpression[0]);

        for (int i = 2; i < validExpression.length; i += 2) {
            String operator = validExpression[i - 1];
            int number = Integer.parseInt(validExpression[i]);

            if ("+".equals(operator)) {
                result += number;
            } else if ("-".equals(operator)) {
                result -= number;
            }
        }
        //System.out.println(Arrays.toString(expression));
        return result;
    }
    private static String removePlusSign(String str) {
        // Remove '+' sign at the beginning of the string
        return str.startsWith("+") ? str.substring(1) : str;
    }
    private static boolean isValidNumber(String str) {
        // Check if the string is a valid integer
        return str.matches("-?\\d+");
    }
    private static boolean isValidOperator(String str) {
        // Check if the string is either "+" or "-"
        return "+".equals(str) || "-".equals(str);
    }
}

