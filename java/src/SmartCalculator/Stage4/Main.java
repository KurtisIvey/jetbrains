package SmartCalculator.Stage4;

import java.util.Arrays;
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
                int result = evaluateExpression(input);
                System.out.println(result);

            }
        }

    }


    public static int evaluateExpression(String[] expression) {
        // set initial result to first int in expression arr
        int result = Integer.parseInt(expression[0]);
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
        //System.out.println(Arrays.toString(expression));

        for (int i = 2; i < expression.length; i += 2) {
                String operator = expression[i - 1];
                int number = Integer.parseInt(expression[i]);

            if ("+".equals(operator)) {
                result += number;
            } else if ("-".equals(operator)) {
                result -= number;
            }

        }


        //System.out.println(Arrays.toString(expression));
        return result;
    }


}

