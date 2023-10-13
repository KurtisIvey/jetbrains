package TrafficLight.Stage2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the traffic management system!");
        Scanner scanner = new Scanner(System.in);

        int roads = getValidInput(scanner, "Input the number of roads:");
        int interval = getValidInput(scanner, "Input the interval:");
        processMenu(scanner);
    }

    public static String menuText() {
        return """
            Menu:
            1. Add road
            2. Delete road
            3. Open system
            0. Quit
            """;
    }

    public static void processMenu(Scanner scanner) {
        int userInput;
        do {
            System.out.print(menuText());
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Road added");
                    // Add road functionality here
                    break;
                case 2:
                    System.out.println("Road deleted");
                    // Delete road functionality here
                    break;
                case 3:
                    System.out.println("System opened");
                    // Open system functionality here
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (userInput != 0);
        System.out.println("Bye!");
        scanner.close();


    }


    public static int getValidInput(Scanner scanner, String prompt) {
        int input = -1; // Initialize input with -1
        String userInput;
        do {
            System.out.print(prompt);
            userInput = scanner.next();
            if (!userInput.matches("\\d+")) {
                System.out.printf("Error: \"%s\" isn't a valid number.\n", userInput);
            } else {
                input = Integer.parseInt(userInput);
                if (input <= 0) {
                    System.out.println("Error: Please enter a number greater than 0.");
                }
            }
        } while (input <= 0);
        return input;
    }
}
